package twopointer;

import java.util.*;

public class E2UnionOfTwoSortedArrays {
    /*
    Time Complexity: O(m+n), Because at max i runs for n times and j runs for m times. When there are no common elements in arr1 and arr2 and all elements in arr1, arr2 are distinct. 

Space Complexity : O(m+n) {If Space of Union ArrayList is considered} O(1) {If Space of union ArrayList is not considered}
    */

    public static List<Integer> betterApproach(int[] arr1, int[] arr2, int n, int m) {
        List<Integer> Union = new ArrayList<>();
        int i = 0, j = 0;

        while (i < n && j < m) {
            if (arr1[i] < arr2[j]) {
                // Add if empty or not duplicate
                if (Union.isEmpty() || Union.get(Union.size() - 1) != arr1[i])
                    Union.add(arr1[i]);
                i++;
            } else if (arr2[j] < arr1[i]) {
                if (Union.isEmpty() || Union.get(Union.size() - 1) != arr2[j])
                    Union.add(arr2[j]);
                j++;
            } else {
                if (Union.isEmpty() || Union.get(Union.size() - 1) != arr1[i])
                    Union.add(arr1[i]);
                i++;
                j++;
            }
        }

        while (i < n) {
            if (Union.isEmpty() || Union.get(Union.size() - 1) != arr1[i])
                Union.add(arr1[i]);
            i++;
        }

        while (j < m) {
            if (Union.isEmpty() || Union.get(Union.size() - 1) != arr2[j])
                Union.add(arr2[j]);
            j++;
        }
        return Union;
    }
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] arr2 = {2, 3, 4, 4, 5, 11, 12};
        int n = arr1.length, m = arr2.length;

        List<Integer> result = betterApproach(arr1, arr2, n, m);

        System.out.print("Union of arr1 and arr2 is: ");
        for (int val : result) System.out.print(val + " ");
    }
}

