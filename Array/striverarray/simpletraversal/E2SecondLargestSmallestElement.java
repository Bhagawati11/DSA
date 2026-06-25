package striverarray;
import java.util.Arrays;



public class  E2SecondLargestSmallestElement{
    //brute force approach : inbuilt sorting methods
    //Time Complexity: O(N log N), for sorting the array.
// Space Complexity: O(1), as we are using a constant amount of space for variables.
public static void getElements(int[] arr, int n) {

    if (n == 0 || n == 1) {
        System.out.println(-1 + " " + -1); // Print -1 for both second smallest and second largest
        return;
    }
    Arrays.sort(arr);
    int small = arr[1];
    int large = arr[n - 2];
    System.out.println("Second smallest is " + small);
    System.out.println("Second largest is " + large);
}
//Algorithm : 
// Perform a single traversal to find the smallest and largest elements in the array.
// After that, traverse the array again to find the element just greater than the smallest element (this will be the second smallest).
// Similarly, find the element just smaller than the largest element (this will be the second largest).
//Time Complexity: O(N), we do two linear traversals in our array.
// Space Complexity: O(1), as we are using a constant amount of space for variables.

public static int[] betterApproach(int[] arr) {
    int max = Integer.MIN_VALUE;
    int min = Integer.MAX_VALUE;

    for (int i = 0; i < arr.length; i++) {
        if (max < arr[i])
            max = arr[i];
        if (min > arr[i])
            min = arr[i];
    }
    int sec_max = Integer.MIN_VALUE;
    int sec_min = Integer.MAX_VALUE;
    for (int i = 0; i < arr.length; i++) {
        if (sec_max < arr[i] && arr[i] < max)
            sec_max = arr[i];
        if (sec_min > arr[i] && arr[i] > min)
            sec_min = arr[i];
    }
    return new int[] { sec_max, sec_min };
}

public static int[] optimalApproach(int[] arr) {
    int max = Integer.MIN_VALUE;
    int sec_max = Integer.MIN_VALUE;

    int sec_min = Integer.MAX_VALUE;
    int min = Integer.MAX_VALUE;

    for (int i = 0; i < arr.length; i++) {
        if (arr[i] > max) {
            sec_max = max;
            max = arr[i];

        } else if (arr[i] > sec_max)
            sec_max = arr[i];
    }
    for (int i = 0; i < arr.length; i++) {
        if (arr[i] < min) {
            sec_min = min;
            min = arr[i];
        }
        else if (arr[i] < sec_min) {
            sec_min = arr[i];
        }
    }
    
    return new int[] {sec_max,sec_min};
}
    
    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 6, 7, 5};
        
        int n = arr.length;

        E2SecondLargestSmallestElement.getElements(arr, n);
        System.out.println(Arrays.toString(betterApproach(arr)));
         System.out.println(Arrays.toString(optimalApproach(arr)));

    }
}



    
