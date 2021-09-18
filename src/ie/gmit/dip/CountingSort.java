package ie.gmit.dip;

//Code adapted from https://www.javainuse.com/java/countingsort 

public class CountingSort {
	
    public void countingSort(int[] arr) {
    	//Determine the key range of the input array
        int arrayLength = arr.length;
        if (arrayLength == 0)
            return;
        //Loop through the array to find maximum and minimum elements 
        int max = arr[0], min = arr[0];
        for (int i = 1; i < arrayLength; i++) {
            if (arr[i] > max)
                max = arr[i];
            if (arr[i] < min)
                min = arr[i];
        }
        int range = (max - min) + 1; //Key range assigned to an int variable
        //Initialise an array of size range to store the sorted output
        int[] count = new int[range];
        //initialize the occurrence of each element in the count array 
        for (int i = 0; i < arrayLength; i++)
            count[arr[i] - min]++;
        //calculate sum of indexes 
        for (int i = 1; i < range; i++)
            count[i] += count[i - 1];
        //Construct the sorted count array according to the sum of indexes
        int j = 0;
        for (int i = 0; i < range; i++)
            while (j < count[i])
                arr[j++] = i + min;
    }
	
}
