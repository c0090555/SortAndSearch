//introduced in Jon Bentley's Programming Pearls 
//specially good for extremely large number of  elements
//key idea:  It works by thinking of a chunk of memory as a set of numbered bits. 
//Each number to be sorted should be thought of as a bit in that chunk of memory.
//So, after all the bits are set, then it is a simple matter to obtain the sorted numbers by starting from the beginning (or the end if reverse order is required) and checking if a bit is set.  If so, then it is moved to the output buffer. 

//pay attention to the potential overflow the range
//Time complexity: O(n)

public class BitmapSort {
	public int[] bitmapSort(int[] numbers) {
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < numbers.length; i++) {
			if (numbers[i] > max) {
				max = numbers[i];
			}
			if (numbers[i] < min) {
				min = numbers[i];
			}
		}
		long N = max - min;
		byte[] bitmap = new byte[(int) N / 8 + 1];
		for (int i = 0; i < numbers.length; i++) {
			bitmap[(int) ((long) (numbers[i] - min) / 8)] |= 1 << (int) ((long) (numbers[i] - min) % 8);
		}
		int k = 0;
		for (int i = 0; i < bitmap.length; i++) {
			for (int j = 0; j < 8; j++) {
				System.out.println("i " + i);
				System.out.println("j " + j);
				if ((bitmap[i] & (1 << j)) > 0) {
					numbers[k] = i * 8 + j + min;
					k++;
				}
			}
		}
		return numbers;

	}

	public static void main(String[] args) {
		int[] numbers = { 3, 122, 5, 6, 1 };
		BitmapSort o = new BitmapSort();
		numbers = o.bitmapSort(numbers);
		for (int i = 0; i < numbers.length; i++) {
			System.out.print(numbers[i] + " ");
		}
	}
}
