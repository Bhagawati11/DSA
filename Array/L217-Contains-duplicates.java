import java.util.*;

class Solution {

    //By using the concept of sorting the array
    //time complexity : O(log(n))
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for(int i =1;i<nums.length;i++){
            if(nums[i-1]==nums[i])
                return true;
        }
        return false;
    }

    //optimised approach : using hashset
    //time complexity : O(n)
    //space complexity : O(n)
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> seen = new HashSet<>();
        for (int num : nums) {
           if (seen.contains(num)) {
            return true;
        }
        seen.add(num);
        }
        return false; 
    }

    //using hashmap
    //time complexity : O(n)
    //space complexity : O(n)
    public boolean containsDuplicate(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            if (map.get(num) > 1){
                return true;
            }
        }
        return false;
    }
}