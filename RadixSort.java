//Time Complexity: Worst case: O(kn) for n keys with fewer than k digits
public class RadixSort {
	public void LSDRadixSort(int[] arr) {
		int len = arr.length;
		if (len <= 1) {
			return;
		}
		// find the maximum value to determine k
		int max = arr[0];
		for (int i = 1; i < len; i++) {
			if (arr[i] > max) {
				max = arr[i];
			}
		}
		int exp = 1;
		int[] bucket = new int[10];
		int[] b = new int[len];
		while (max / exp > 0) {
			bucket = new int[10];
			for (int i = 0; i < len; i++) {
				bucket[(arr[i] / exp) % 10]++;// bucket sort
			}
			for (int j = 1; j < 10; j++) {
				bucket[j] += bucket[j - 1];// get the final locations
			}
			for (int k = len - 1; k >= 0; k--) {
				bucket[(arr[k] / exp) % 10]--;
				b[bucket[(arr[k] / exp) % 10]] = arr[k];

			}
			for (int m = 0; m < len; m++) {
				arr[m] = b[m];// update arr
			}
			for (int i = 0; i < arr.length; i++) {
				System.out.print(arr[i] + " ");

			}
			System.out.println("");
			exp *= 10;
		}

	}

	public static void main(String[] args) {
		RadixSort o = new RadixSort();
		int[] arr = { 3, 2, 5, 211, 23, 4, 2, 1, 5 };
		o.LSDRadixSort(arr);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}

}
