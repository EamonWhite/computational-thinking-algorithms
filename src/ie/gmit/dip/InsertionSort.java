package ie.gmit.dip;

/*
 * Code taken from COMP08033 Computational Thinking with Algorithms, 
 * Patrick Mannion GMIT – Sorting Algorithms Part 2
 */

public class InsertionSort {
	
	public void insertionSort(int[] a) {
		for (int i = 1; i < a.length; i++) {
			int key = a[i]; //The key is assigned the element in index i
			int j = i - 1; //Declare an int variable to access indexes to the left of index i
			/*
			Check elements in indexes before the key index
			Move all elements > key right one position*/
			while (j >= 0 && a[j] > key) {
				a[j + 1] = a[j];
				j = j - 1;
			}
			a[j + 1] = key; //The key is assigned its new index
		}
	}
	
}
