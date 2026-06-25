package twopointer;

public class E1RemoveDuplicates {
    /*
    l1 → explorer pointer / fast pointer
    scans every element
    l2 → placement pointer / slow pointer
    points to the last unique element’s index
    next unique element should go at l2 + 1
    */
    public static int optimalApproach(int[] arr) {
        int l1 = 0;
        int l2 = 0;
        while (l1 < arr.length) {
            if (arr[l1] != arr[l2]) {
                l2++;
                arr[l2] = arr[l1];
            }
            l1++;
        }
        return l2 + 1;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 1, 2, 2, 2, 3, 3 };
        int k = optimalApproach(arr);
        for (int i = 0; i < k; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
/*
Algorithm:
1. Use two pointers:
   - l1 scans the entire array.
   - l2 tracks the last position of unique elements.
2. Traverse the array using l1.
3. Whenever a new unique element is found (arr[l1] != arr[l2]):
   - Move l2 one step ahead.
   - Place the unique element at arr[l2].
4. After traversal, first (l2 + 1) elements contain unique values.
5. Return (l2 + 1) as the count of unique elements.

Time Complexity:
O(N) → Each element is visited once.

Space Complexity:
O(1) → Duplicate removal is done in-place without extra space.
*/
