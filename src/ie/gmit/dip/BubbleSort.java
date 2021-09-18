package ie.gmit.dip;

/*
 * Code taken from COMP08033 Computational Thinking with Algorithms, 
 * Patrick Mannion GMIT – Sorting Algorithms Part 2
 */
 
public class BubbleSort {

	public void bubbleSort(int[] a) {
		int outer, inner; //2 int values declared for loop counters
		for (outer = a.length - 1; outer > 0; outer--) { //Outer loop, counting down from final index 
			for (inner = 0; inner < outer; inner++) { //Inner loop, bubbling up from index 0
				if (a[inner] > a[inner + 1]) { //If inversion.. 
					int temp = a[inner]; //swap elements
					a[inner] = a[inner + 1];
					a[inner + 1] = temp;
				}
			} //At the end of the inner loop, the largest value will be at the end
		} 
	}
	
}
