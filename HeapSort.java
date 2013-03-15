//Time Complexity: average & worst: O(nlgn), not a stable sort
/*
 HeapSort versus MergeSort:
 Heapsort is not a stable sort; merge sort is stable.
 Merge sort parallelizes well and can achieve close to linear speedup with a trivial implementation; heapsort is not an obvious candidate for a parallel algorithm.
 Merge sort can be adapted to operate on linked lists with O(1) extra space. Heapsort can be adapted to operate on doubly linked lists with only O(1) extra space overhead.
 Merge sort is used in external sorting; heapsort is not. Locality of reference is the issue.
 */
public class HeapSort {
	public int[] heapSortIncreasing(int[] arr) {
		if (arr.length <= 1) {
			return arr;
		}
		int[] sort = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			minHeapify(arr);
			sort[i] = arr[0];
			arr[0] = Integer.MAX_VALUE;// equivalent to swap the root value to
										// the last node
		}
		return sort;

	}
 
	public void minHeapify(int[] arr) {
		int count = arr.length;
		if (count <= 1) {
			return;
		}
		int start = (count - 2) / 2;/* index of last parent */
		while (start >= 0) {
			siftDown(arr, start, count - 1);
			start--; 
		}
	}

	public void siftDown(int[] arr, int start, int end) {
		int root = start;
		int swap = root;
		int leftChild = root * 2 + 1;
		int rightChild = root * 2 + 2;
		while (leftChild <= end) {/* leftChild exists */
			if (arr[leftChild] < arr[root]) {
				swap = leftChild;
			}
			if (rightChild <= end) {/* rightChild exists */
				if (arr[rightChild] < arr[swap]) {
					swap = rightChild;
				}
			}
			if (swap != root) {
				swap(arr, swap, root);
				root = swap;
				leftChild = 2 * root + 1;
				rightChild = 2*root+2;
			} else {
				return;
			}
		}
	}

	public int[] heapSortDecreasing(int[] arr) {
		if (arr.length <= 1) {
			return arr;
		}
		int[] decreasing = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			maxHeapify(arr);
			decreasing[i] = arr[0];
			arr[0] = Integer.MIN_VALUE;
		}
		return decreasing;
	}

	public void maxHeapify(int[] arr) {
		int count = arr.length;
		if (count <= 1) {
			return;
		}
		int end = 1;
		while (end < count) {
			siftUp(arr, 0, end);
			end++;
		}

	}

	public void siftUp(int[] arr, int start, int end) {
		int last = end;
		int parent = (last - 1) / 2;
		while (parent >= start) {
			if (arr[last] > arr[parent]) {
				swap(arr, last, parent);
				last = parent;
				parent = (last - 1) / 2;
			} else {
				return;
			}
		}
	}

	public void swap(int[] arr, int m, int n) {
		int temp = arr[m];
		arr[m] = arr[n];
		arr[n] = temp;
	}

	public static void main(String[] args) {
		HeapSort o = new HeapSort();
		int[] a = { 3, 4, 1, 1, 2, 6 };
		int[] b = o.heapSortIncreasing(a);
		for (int i = 0; i < b.length; i++) {
			System.out.print(b[i] + " ");
		}
		System.out.println();
		int[] c = { 3, 4, 1, 1, 2, 6 };
		int[] d = o.heapSortDecreasing(c);
		for (int i = 0; i < d.length; i++) {
			System.out.print(d[i] + " ");
		}
	}
}
