//pay attention to the conditions in partition method
//Time
public class QuickSort {
	public void quickSort(int[] arr) {
		if (arr.length <= 1) {
			return;
		}
		quickSort(arr, 0, arr.length - 1);
		System.out.println(arr[0]);
	}

	public void quickSort(int[] arr, int start, int end) {
		if (start < end) {
			int pivot = partition(arr, start, end);
			System.out.println(pivot + " p");
			if (start < pivot - 1)
				quickSort(arr, start, pivot - 1);
			if (pivot < end)
				quickSort(arr, pivot, end);

		}
	}

	public int partition(int[] arr, int start, int end) {
		int pivot = arr[(start + end) / 2];
		int left = start;
		int right = end;
		while (left <=right) {
			while (left <= end && arr[left] < pivot) {
				left++;
			}
			while (right > 0 && arr[right] > pivot) {
				right--;
			}
			if (left <= right) {
				swap(arr, left, right);
				left++;
				right--;
			}
		}
		System.out.println(left + "left");
		return left;
	}

	public void swap(int[] arr, int m, int n) {
		int temp = arr[m];
		arr[m] = arr[n];
		arr[n] = temp;
	}

	public static void main(String[] args) {
		QuickSort o = new QuickSort();
		int[] a = { 3, 2, 5, 7, 4, 2, 1 };
		o.quickSort(a);
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i]+ " ");
		}
	}

}
