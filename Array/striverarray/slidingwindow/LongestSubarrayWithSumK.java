package slidingwindow;
import java.util.*;

public class LongestSubarrayWithSumK {
    public static int optimalApproach(int[] arr, int k) {
        int left = 0;
        int right = 0;
        int sum = arr[0];
        int maxLen = 0;

        while (right < arr.length) {
            while (left <= right && sum > k) {
                sum -= arr[left];
                left++;
            }
            if (sum == k) {
                maxLen = Math.max(maxLen, right - left + 1);
            }
            right++;
            if (right < arr.length) {
                sum += arr[right];
            }
        }
        return maxLen;
    }

//for negative numbers

public static int longestSubarray(int[] arr, int k) {
    HashMap<Integer, Integer> map = new HashMap<>();

    int sum = 0;
    int maxLen = 0;
    
    for (int i = 0; i < arr.length; i++) {
        sum += arr[i];
        if (sum == k) {
            maxLen = i + 1;
        }
        if (map.containsKey(sum - k)) {
            int len = i - map.get(sum - k);
            maxLen = Math.max(maxLen, len);
        }
        map.putIfAbsent(sum, i);
    }
    return maxLen;
}
    public static void main(String [] args){
        int[] arr = { 10, 5, 2, 7, 1, 9} ;
        System.out.println(optimalApproach(arr,15));
    }

}
