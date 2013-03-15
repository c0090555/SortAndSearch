//Reservoir sampling is a family of randomized algorithms for randomly choosing k samples from a list S containing n items, where n is either a very large or unknown number. 
//this is a modified version of Fisher and Yates shuffle where we only concern the first k element
/*
 * s: input array;r: result array;k: number of samples;n: length of input array
 * All arrays are 0-based
 * 1.when size of input array is known:
 * for i in 0..k-1{
 * 	r[i]=s[i]
 * }
 * for i in k..n-1{
 * 	generate a random number j where 0<=j<=i
 * 	if(j<k){
 * 		r[j]=s[i]
 *  }
 * }
 ************************** 
 * 2.when size of input array is unknown
 * for i in 0..k-1{
 *   r[i]=s[i]
 * }
 * while s.hasMoreElement{
 *   generate a random number i where 0<=i<=number of element processes in input array(counter)
 *   if(i<k){
 *   	r[i]=s.next
 *   }
 * }  
 * 
 * 
 */

import java.util.*;

public class ReserviorSampling {
	public int[] sampleWithKnownSize(int[] source, int k) {
		if (source.length <= k) {
			return source;
		}
		int[] result = new int[k];
		int i;
		for (i = 0; i < k; i++) {
			result[i] = source[i];
		}

		for (i = k; i < source.length; i++) {
			int j = (int) (Math.random() * (i + 1));// generate a random number
													// j where 0<=j<=i
			if (j < k) {
				result[j] = source[i];
			}
		}
		return result;
	}

	public int[] sampleWithUnknownSize(ArrayList<Integer> source, int k) {
		if (k <= 0) {
			return null;
		}
		int[] result = new int[k];
		int counter = 0;
		Random r = new Random();
		while (!source.isEmpty()) {
			if (counter <= k - 1) {
				result[counter] = source.get(0);
			} else {
				int i = r.nextInt(counter + 1); // generate a random number i
												// where 0<=i<=counter
				if (i < k) {
					result[i] = source.get(0);
				}
			}
			counter++;
			source.remove(0);
		}
		return result;
	}

	public static void main(String[] args) {
		ReserviorSampling o = new ReserviorSampling();
		int[] s = { 3, 1, 2, 5, 6, 8 };
		int k = 3;
		int[] r = o.sampleWithKnownSize(s, k);
		for (int i = 0; i < r.length; i++) {
			System.out.print(r[i] + " ");
		}
		ArrayList<Integer> s2 = new ArrayList<Integer>();
		s2.add(3);
		s2.add(4);
		s2.add(1);
		s2.add(7);
		s2.add(9);
		int[] r2 = o.sampleWithUnknownSize(s2, k);
		System.out.println();
		for (int j = 0; j < r2.length; j++) {
			System.out.print(r2[j] + " ");
		}
	}

}
