//two solutions here
//solution 1: use two extra ArrayLists to store element smaller and bigger than pivot separately
//idea comes from:http://pine.cs.yale.edu/pinewiki/QuickSelect
//solution 2: use two pointers instead of two ArrayLists - use iterative solution to save spaces
//idea comes from: http://en.wikipedia.org/wiki/Selection_algorithm
//Time complexity of both solutions are O(n)

import java.util.*;

public class QuickSelect {
	public int selectKth1(ArrayList<Integer> arr, int k) {
		int len = arr.size();
		if (k > len || k <= 0) {
			return -1;
		}

		ArrayList<Integer> smaller = new ArrayList<Integer>();
		ArrayList<Integer> bigger = new ArrayList<Integer>();
		int low = 0;
		int high = len - 1;
		int mid = (low + high) / 2;
		int pivot = arr.get(mid);
		for (int i = 0; i < len; i++) {
			if (arr.get(i) < pivot) {
				smaller.add(arr.get(i));
			} else if (arr.get(i) > pivot) {
				bigger.add(arr.get(i));
			}
		}

		if (k > smaller.size() && k <= len - bigger.size()) {
			return pivot;
		} else if (k <= smaller.size()) {
			return selectKth1(smaller, k);
		} else {
			return selectKth1(bigger, k - (len - bigger.size()));
		}
	}

	public int selectKth2(int[] arr, int left, int right, int k) {
		int len = arr.length;
		if (k > len || k <= 0) {
			return -1;
		}
		int pivotIndex;
		int newPivotIndex;
		int pivotDist;

		while (left <= right) {
			pivotIndex = (left + right) / 2;
			newPivotIndex = partition(arr, left, right, pivotIndex);
			for (int i = 0; i < arr.length; i++) {
				System.out.print(arr[i] + " ");
			}
			System.out.println();
			pivotDist = newPivotIndex - left + 1;
			if (pivotDist == k) {
				return arr[newPivotIndex];
			} else if (k < pivotDist) {
				right = newPivotIndex - 1;
			} else {
				left = newPivotIndex + 1;
				k = k - pivotDist;
			}
		}

		return -1;
	}

	public int partition(int[] arr, int low, int high, int pivotIndex) {
		if (low > high || pivotIndex < low || pivotIndex > high) {
			return -1;
		}
		int pivot = arr[pivotIndex];
		swap(arr, high, pivotIndex);

		int storeIndex = low;
		for (int i = low; i <= high; i++) {
			if (arr[i] < pivot) {
				swap(arr, i, storeIndex);
				storeIndex++;
			}
		}
		swap(arr, storeIndex, high);// move pivot element to its final location
		return storeIndex;

	}

	public void swap(int[] arr, int m, int n) {
		int temp = arr[m];
		arr[m] = arr[n];
		arr[n] = temp;
	}

	public static void main(String[] args) {
		QuickSelect o = new QuickSelect();
		int[] arr = { 1, 2, 5, 3, 7, 4, 4, 7 };
		ArrayList<Integer> a = new ArrayList<Integer>();
		for (int i = 0; i < arr.length; i++) {
			a.add(arr[i]);
		}
		int k = 9;
		// System.out.println(o.selectKth1(a, k));
		System.out.println(o.selectKth2(arr, 0, arr.length - 1, 9));
	}

}
