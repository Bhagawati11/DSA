class Solution {
    //naive approach : O(n^2) time complexity
    static int maxProfit(int[] prices) {
        int n = prices.length;
        int res = 0;

        // Explore all possible ways to buy and sell stock
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                res = Math.max(res, prices[j] - prices[i]);
            }
        }
        return res;
    }

    //optimised approach : O(n) time complexity
    //at every step, we keep track of the minimum buy price of stock encountered so far. For every price, 
    // we subtract with the minimum so far and if we get more profit than the current result, we update the result.
    public int maxProfit(int[] prices) {
        int minValue = prices[0];
        int profit = 0;
        for(int i=1;i<prices.length;i++){
            if(minValue>prices[i]){
                minValue = Math.min(minValue,prices[i]);
            }
            profit = Math.max(profit,prices[i]-minValue);
        }
        return profit;
    }
}