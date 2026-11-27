// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/

// Solution: Greedy — Collect Every Upslope — O(n) time, O(1) space
class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                profit += prices[i] - prices[i - 1];
            }
        }
        return profit;
    }
}

// Solution 2: Peak-Valley — O(n) time, O(1) space
class Solution2 {
    public int maxProfit(int[] prices) {
        int profit = 0, i = 0, n = prices.length;
        while (i < n - 1) {
            while (i < n - 1 && prices[i] >= prices[i + 1]) i++;
            int valley = prices[i];
            while (i < n - 1 && prices[i] <= prices[i + 1]) i++;
            profit += prices[i] - valley;
        }
        return profit;
    }
}
