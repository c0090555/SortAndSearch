//Time Complexity: average & worst: O(nlgn),stable sort
public class MergeSort {
	public void mergeSort(int[] arr, int start, int end) {
		if (start < end) {
			int mid = (start + end) / 2;
			mergeSort(arr, start, mid);
			mergeSort(arr, mid + 1, end);
			merge(arr, start, mid, end);
		}

	}

	public void merge(int[] arr, int start, int mid, int end) {
		// use a helper array
		int leftStart = start;
		int rightStart = mid + 1;
		int[] helper = new int[end - start + 1];
		for (int i = start; i <= end; i++) {
			helper[i - start] = arr[i];
		}
		int index = start;
		while (leftStart <= mid && rightStart <= end) {
			if (helper[leftStart - start] <= helper[rightStart - start]) {
				arr[index] = helper[leftStart - start];
				leftStart++;
			} else {
				arr[index] = helper[rightStart - start];
				rightStart++;
			}
			index++;
		}
		// merge the left remaining part
		for (int j = leftStart; j <= mid; j++) {
			arr[index] = helper[j - start];
			index++;
		}
	}

	public static void main(String[] args) {
		MergeSort o = new MergeSort();
		int[] a = { 3, 2, 5, 1, 3, 45, 6 };
		o.mergeSort(a, 0, a.length - 1);
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] +" ");
		}
	}
}
