public class E4MaximumConsecutiveOnes {
/*
Algorithm:
1. Traverse the array from left to right.
2. Count consecutive 1s.
3. If 0 is encountered, compare current count with maximum count
   and reset count to 0.
4. Return the maximum count found.

Time Complexity:
O(N) → Each element is visited once.

Space Complexity:
O(1) → No extra space used.
*/
    public int findMaxConsecutiveOnes(int[] nums) {

        // count    -> stores current streak of consecutive 1s
        // maxCount -> stores maximum streak seen so far
        int count = 0;
        int maxCount = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1)
                count++;

            if (nums[i] == 0 || i == nums.length - 1) {
                maxCount = (count > maxCount) ? count : maxCount;
                count = 0;
            }
        }
        return maxCount;
    }
}