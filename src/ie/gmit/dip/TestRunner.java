package ie.gmit.dip;

import java.util.Arrays;
import java.util.Random;

public class TestRunner {

	public static int[] randomArray() {
		int randomNumbers = 100;
		Random num = new Random();
		int[] array = new int[randomNumbers];
		for (int i = 0; i < randomNumbers; i++) {
			int randomNum = num.nextInt(100);
			array[i] = randomNum;
		}
		return array;
	}
	
	public static void main(String[] args) {
		BubbleSort bs = new BubbleSort();
		InsertionSort is = new InsertionSort();
		SelectionSort ss = new SelectionSort();
		MergeSort ms = new MergeSort();
		CountingSort cs = new CountingSort();
		
		int numRuns = 10;
		double[] results = new double[numRuns];
		
		for (int run = 0; run < numRuns; run++) {
			int[] arr = randomArray();
//			System.out.println(Arrays.toString(arr));
			long startTime = System.nanoTime();
//			bs.bubbleSort(arr);
//			is.insertionSort(arr);
//			ss.selectionSort(arr);
			ms.mergeSort(arr, arr.length);
			// cs.countingSort(arr);
			long endTime = System.nanoTime();
			long timeElapsed = endTime - startTime;
			double timeMillis = timeElapsed /  Math.pow(10, 6);
			results[run] = timeMillis;
		}
		System.out.println(Arrays.toString(results));
		double sum = 0.0;
		for (int i = 0; i < results.length; i++) {
			sum = sum + results[i];
		}
		double average = sum / numRuns;
		System.out.printf("%.3f", average);
		
	}
	
}
