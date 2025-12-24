class Solution {
    //brute force approach :nested loops 
    //time complexity : (O(n2))
    public int[] twoSum(int[] nums, int target){
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                int sum = nums[i]+nums[j];
                if(sum==target){
                    return new int[] {i,j};          
                }
            }
        }
    return null;
    }
    //optimised approach : using hashMap
    //time complexity : (O(n))
    //space complexity : (O(n))
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> hsm = new HashMap<Integer,Integer>();
        for(int i =0;i<nums.length;i++){
            int num = target - nums[i];
            if(hsm.containsKey(num)){
                return new int[] {hsm.get(num),i};
            }
            else{
                hsm.put(nums[i],i);
            }
        }
        return null;
    }
}