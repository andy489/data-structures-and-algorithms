// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/

// Solution: Four-State DP — O(n) time, O(1) space
class Solution {
    public int maxProfit(int[] prices) {
        int buy1 = -prices[0], sell1 = 0, buy2 = -prices[0], sell2 = 0;
        for (int i = 1; i < prices.length; i++) {
            buy1  = Math.max(buy1,  -prices[i]);
            sell1 = Math.max(sell1, buy1 + prices[i]);
            buy2  = Math.max(buy2,  sell1 - prices[i]);
            sell2 = Math.max(sell2, buy2 + prices[i]);
        }
        return sell2;
    }
}

// Solution 2: Left-Right Prefix DP — O(n) time, O(n) space
class Solution2 {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[] left = new int[n];
        int[] right = new int[n];

        int minPrice = prices[0];
        for (int i = 1; i < n; i++) {
            left[i] = Math.max(left[i - 1], prices[i] - minPrice);
            minPrice = Math.min(minPrice, prices[i]);
        }

        int maxPrice = prices[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            right[i] = Math.max(right[i + 1], maxPrice - prices[i]);
            maxPrice = Math.max(maxPrice, prices[i]);
        }

        int profit = 0;
        for (int i = 0; i < n; i++) {
            profit = Math.max(profit, left[i] + right[i]);
        }
        return profit;
    }
}
