import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
/*sorted the array and then count the consecutive elements and update the maximum 
count whenever we encounter a non-consecutive element. Finally, return the maximum 
count of consecutive elements found. 
//time complexity is O(n log n) due to sorting, and space complexity is O(1) as 
we are using only a constant amount of extra space.
*/
class Solution {
    public int longestConsecutive(int[] nums) {
       int n = nums.length;
        
        if (n == 0) {
            return 0;
        }

        Arrays.sort(nums);

        int cnt = 1;
        int maxi = 0;

        for (int i = 1; i < n; i++) {
            if (nums[i] != nums[i - 1]) {
                if (nums[i] == nums[i - 1] + 1) {
                    cnt++;
                } else {
                    maxi = Math.max(maxi, cnt);
                    cnt = 1;
                }
            }
        }

        return Math.max(maxi, cnt);
    }
    /*This approach uses a HashMap to keep track of which numbers have been explored. 
    It iterates through each number in the input array and for each number, 
    it checks both forward and backward to find the length of the consecutive 
    sequence it belongs to. The length of the longest consecutive sequence is 
    updated whenever a longer sequence is found. 
    
    The time complexity of this approach is O(n) on average, as each number 
    is processed at most twice (once when checking forward and once when checking backward). 
    The space complexity is O(n) due to the HashMap storing the explored numbers.
    nested loops are avoided by marking numbers as explored, ensuring that each number is only processed once, It is known as amortized O(n) time complexity.
    */
    public int longestConsecutive1(int[] nums) {
       int longlength =0;
        Map<Integer,Boolean> explored = new HashMap<>();
        //Initializing every elemnet in the Map as untraversed and False
        for (int num : nums)
        {
            explored.put(num,Boolean.FALSE);
        }

        for(int num : nums)
        {
            
            int currlength =1;
            //First Check forward to find any sub seq
            int nextnum=num+1;
            while(explored.containsKey(nextnum) && explored.get(nextnum) == false)
            {
                currlength++;
                explored.put(nextnum,Boolean.TRUE);
                nextnum++;
            }
            // Check Backward for any subseq.

            int prevnum=num-1;

            while(explored.containsKey(prevnum) && explored.get(prevnum)==false)
            {
                currlength++;
                explored.put(prevnum,Boolean.TRUE);
                prevnum--;
            }
            //At last storing the max length found till now

            longlength=Math.max(longlength,currlength);
        }
        return longlength; 
    }
    /*This approach uses a HashSet to store the unique numbers from the input array.
    It iterates through each number in the HashSet and checks if it is the start 
    of a sequence (i.e., if the previous number is not in the set). If it is the 
    start of a sequence, it then counts the length of the consecutive sequence by
    checking for the presence of the next numbers in the set. The length of the 
    longest consecutive sequence is updated whenever a longer sequence is found.

    The time complexity of this approach is O(n) on average, as each number is 
    processed at most once when checking for the start of a sequence and counting 
    the length of the sequence. The space complexity is O(n) due to the HashSet 
    storing the unique numbers from the input array. again it is known as amortized O(n) 
    time complexity because each number is processed at most once when checking for 
    the start of a sequence and counting the length of the sequence, and the HashSet 
    allows for O(1) average time complexity for lookups. 
    */
    public int longestConsecutive2(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums)
          set.add(num);
        int longest = 0;
        for (int num : set) {
        // check if start of sequence
            if (!set.contains(num - 1)) {
               int curr = num;
               int len = 1;
               while (set.contains(curr + 1)) {
                  curr++;
                  len++;
                }
               longest = Math.max(longest, len);
            }
        }
        return longest;
    }
}
