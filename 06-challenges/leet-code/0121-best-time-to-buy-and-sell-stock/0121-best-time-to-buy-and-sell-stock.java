// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/

// Solution: One-Pass Min-Tracking — O(n) time, O(1) space
class Solution {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE, maxProfit = 0;
        for (int price : prices) {
            minPrice   = Math.min(minPrice, price);
            maxProfit  = Math.max(maxProfit, price - minPrice);
        }
        return maxProfit;
    }
}

// Solution 2: Kadane's on Difference Array — O(n) time, O(1) space
class Solution2 {
    public int maxProfit(int[] prices) {
        int currentGain = 0, maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            currentGain = Math.max(0, currentGain + prices[i] - prices[i - 1]);
            maxProfit   = Math.max(maxProfit, currentGain);
        }
        return maxProfit;
    }
}
