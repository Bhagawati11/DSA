package rotationreversalpattern;

public class E1ArrayRotationByOne {
    public static void leftRotateArray(int[] nums) {
        // Store the first element in a temporary variable
        int temp = nums[0];
        // Shift elements to the left
        for (int i = 1; i < nums.length; i++) {
            nums[i - 1] = nums[i];
        }
        // Place the first element at the end
        nums[nums.length - 1] = temp;
    }
    public static void rightRotateArray(int[] nums) {
        // Store the last element in a temporary variable
        int temp = nums[nums.length - 1];
        // Shift elements to the right
        for (int i = nums.length - 2; i >= 0; i--) {
            nums[i + 1] = nums[i];
        }
        // Place the last element at the beginning
        nums[0] = temp;
    }
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
      leftRotateArray(nums);
        // Output the rotated array
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}

    