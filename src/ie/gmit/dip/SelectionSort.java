package ie.gmit.dip;

/*
 * Code taken from COMP08033 Computational Thinking with Algorithms, 
 * Patrick Mannion GMIT – Sorting Algorithms Part 2
 */

public class SelectionSort {
	
	public void selectionSort(int[] a) {
		int outer = 0, inner = 0, min = 0; //3 int values declared, 2 loop counters and 1 for the array min-element index 
		for (outer = 0; outer < a.length -1; outer++) { //The outer counts up
			min = outer;
			for (inner = outer + 1; inner < a.length; inner++) { 
				if (a[inner] < a[min]) { //The inner loop finds the index with the smallest element
					min = inner; //The element in this index is assigned to the min variable
				}
			}
			//The element in a[min] is swapped with the element in a[outer]
			int temp = a[outer];
			a[outer] = a[min];
			a[min] = temp;
		}
	}
	
}

