//suitable for numbers in small range
public class CountSort {
	public void countSort(int[] arr) {
		int len = arr.length;
		if (len <= 1) {
			return;
		}

		// locate the range
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < len; i++) {
			if (arr[i] > max) {
				max = arr[i];
			}
			if (arr[i] < min) {
				min = arr[i];
			}
		}

		int[] count = new int[max - min + 1];
		for (int i = 0; i < len; i++) {
			count[arr[i] - min]++;
		}

		int k = 0;
		for (int j = 0; j < count.length; j++) {
			if (count[j] > 0) {
				while (count[j] > 0) {
					arr[k] = j + min;
					k++;
					count[j]--;
				}
			}
		}

	}

	public static void main(String[] args) {
		CountSort o = new CountSort();
		int[] arr = { 2, 1, 2, 4, 52, 2, -2 };
		o.countSort(arr);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}
}
