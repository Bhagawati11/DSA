package prefixsum;
import java.util.HashMap;

public class LengthOfLongestSubarrayZZeroSum {
    /*
    Maintain running prefix sum and store its first occurrence in a HashMap; whenever the same prefix sum reappears (or sum becomes 0), the subarray between those indices has sum 0, so update the longest length.
    TC : O(n)
    SC : O(n)
    */
   /*
   Traverse array once while maintaining a running prefix sum.
   Use a Java HashMap HashMap to store:
      
   prefixSum -> fir
   For every index:
   Add current element to p
   If prefix sum becomes 0:
   subarray from 
   length = i + 1
   If current prefix sum is already pres
   Let previous o
   Then subarray:
(j+1) → i
   */
    public static int optimalApproach(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int maxLen = 0;
        for (int i = 0; i < arr.length; i++){
            sum += arr[i];
            /*
             * Step 2:
             * If prefix sum becomes 0,
             * subarray from index 0 to i has sum 0
             */
            if (sum == 0) {
                maxLen = i + 1;
            }
            /*
             * Step 3:
             * If same prefix sum seen before,
             * subarray between previousIndex+1 and i has sum 0
             */
            if (map.containsKey(sum)) {
                maxLen = Math.max(maxLen, i - map.get(sum));
            } 
             /*
             * Step 4:
             * Store first occurrence only
             * (earliest index gives maximum length)
             */
            else{
                map.put(sum,i);
            } 
        }
        return maxLen;
    }
    public static void main(String [] args){
        int[] arr = { 6,  -2 ,  2,  -8 ,  1, 7, 4, -10} ;
        System.out.println(optimalApproach(arr));
    }
}
