package striverarray;

public class E3CheckSorted{
    public static boolean check(int[] nums) {

        // Approach:
        // A sorted + rotated array can have at most one "break point"
        // Break point means nums[i] > nums[i+1]
        // 
        // Example:
        // [3,4,5,1,2]
        // Only one break: 5 > 1
        //
        // If more than one break exists,
        // array cannot be sorted and rotated.

        int count = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            // Compare current element with next element
            // (i+1)%n handles circular comparison:
            // last element compares with first element
            if (nums[i] > nums[(i + 1) % n]) {
                count++;
            }
        }
        return count <= 1;
    }
    public static void main(String[] args) {
        int[] arr = { 3, 4, 5, 6, 1, 2 };
        System.out.println(check(arr));

    }
}