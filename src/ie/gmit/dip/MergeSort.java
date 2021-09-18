package ie.gmit.dip;

//Code adapted from https://www.baledung.com/java-merge-sort

public class MergeSort {
	
	/* For the recursive case, the middle index is determined & 2 temp arrays, 
	 * l[] and r[], are created
	 */
	public void mergeSort(int[] a, int n) { // n = a.length
		if (n < 2) {
			return; // Base case
		}
		int mid = n / 2;
		int[] l = new int[mid];
		int[] r = new int[n - mid];

		for (int i = 0; i < mid; i++) {
			l[i] = a[i];
		}
		for (int i = mid; i < n; i++) {
			r[i - mid] = a[i];
		}
		/*
		 * The mergeSort function is called recursively for both sub-arrays
		 */
		mergeSort(l, mid);
		mergeSort(r, n - mid);
		/*
		 * The merge function, which takes in the input and both sub-arrays
		 * and the starting and end indices of both the sub arrays, is called
		 */
		merge(a, l, r, mid, n - mid);
	}
	/*
	 * The merge function compares the elements of both sub-arrays one by one
	 * and places the smaller element into the input array
	 * When the end of one of the sub-arrays is reached, the remaining elements
	 * from the other array are copied into the input array, giving
	 * the final sorted array
	 */
	public static void merge(int[] a, int[] l, int[] r, int left, int right) {

		int i = 0, j = 0, k = 0;
		while (i < left && j < right) {
			if (l[i] <= r[j]) {
				a[k++] = l[i++];
			} else {
				a[k++] = r[j++];
			}
		}
		while (i < left) {
			a[k++] = l[i++];
		}
		while (j < right) {
			a[k++] = r[j++];
		}
	}
	
}
