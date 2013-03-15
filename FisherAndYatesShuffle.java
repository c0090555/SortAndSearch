/*
 * Fisher and Yates shuffle algorithm 
 * s:source array; r: result array; n:size of s
 * All arrays are 0-based
 * 1. when the size of input array is known:
 * r[0]=s[0]
 * for(i=1;i<=n-1;i++){
 * generate a random number j where 0<=j<=i
 * a[i]=a[j]
 * a[j]=s[i]
 * }
 * 
 * **********************************************************
 * 2. when the size of input array is unknown (we can assume it's extremely large)
 * when s.hasMoreElement
 * generate a random number i where 0<=i<=current size of r
 * if(i==current size of r){
 * 		r.append(s.next)
 * }
 * else{
 *      r.append(s[j])
 *      r[j]=s.next
 * }
 *end
 * 
 * 
 * 
 */

import java.util.*;

public class FisherAndYatesShuffle {
	// when the size of input array is known
	public int[] shuffleWithKnownSize(int[] source) {
		int n = source.length;
		if (n <= 1) {
			return source;
		}
		int[] result = new int[n];
		result[0] = source[0];
		for (int i = 1; i <= n - 1; i++) {
			Random r = new Random();
			int j = r.nextInt(i + 1);
			System.out.println("i " + i);
			System.out.println("j " + j);
			System.out.println(r.nextInt(i + 1));

			result[i] = result[j];
			result[j] = source[i];
		}
		return result;

	}

	// when the size of input array is unknown (assuming it's very large)
	public ArrayList<Integer> shuffleWithOutKnownSize(ArrayList<Integer> source) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		while (!source.isEmpty()) {
			int j = (int) (Math.random() * (result.size() + 1));// 0<=j<=result.size()
			if (j == result.size()) {
				result.add(source.get(0));
			} else {
				int element_j = result.get(j);
				result.add(element_j);
				result.set(j, source.get(0));

			}
			source.remove(0);

		}
		return result;

	}

	public static void main(String[] args) {
		FisherAndYatesShuffle o = new FisherAndYatesShuffle();
		int[] source = { 1, 3, 4, 5, 6 };
		int[] result = o.shuffleWithKnownSize(source);
		for (int i = 0; i < result.length; i++) {
			System.out.print(result[i] + " ");
		}
		ArrayList<Integer> s = new ArrayList<Integer>();
		s.add(1);
		s.add(3);
		s.add(6);
		s.add(2);
		s.add(10);
		ArrayList<Integer> r = o.shuffleWithOutKnownSize(s);
		System.out.println();
		for (int j = 0; j < r.size(); j++) {
			System.out.print(r.get(j) + " ");
		}
	}

}
