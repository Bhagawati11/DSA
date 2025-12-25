class Solution {
    //Using Hashset(similar to L1: 2sum)
    //time complexity : O(n*log(n)) + O(n^2)
    //space complexity : O(n)
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            if(nums[i]>0) break;
            Set<Integer> seen = new HashSet<>();
            for (int j = i + 1; j < nums.length; j++) {
                int target = -nums[i] - nums[j];
                if (seen.contains(target)) {
                    res.add(Arrays.asList(nums[i], target, nums[j]));
                    while (j + 1 < nums.length && nums[j] == nums[j + 1])
                        j++;
                }
                seen.add(nums[j]);
            }
        }
        return res;
    }
    //Using 2-pointer(similar to L167:2sum Array is sorter)
    //time complexity : O(n*log(n)) + O(n^2)
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i++) {
            // skip duplicate nums[i]
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    // skip duplicates of left & right
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;
                    left++;
                    right--;
                }
                else if (sum < 0) {
                    left++;
                }
                else {
                    right--;
                }
            }
        }
        return res;
    }
}