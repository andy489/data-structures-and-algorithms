// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/

// Solution 1: Rolling buy/sell arrays — O(n*k) time, O(k) space
class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        if (k >= n / 2) {
            int profit = 0;
            for (int i = 1; i < n; i++) {
                if (prices[i] > prices[i - 1]) {
                    profit += prices[i] - prices[i - 1];
                }
            }
            return profit;
        }
        int[] buy = new int[k];
        int[] sell = new int[k];
        java.util.Arrays.fill(buy, -prices[0]);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < k; j++) {
                buy[j] = Math.max(buy[j], (j == 0 ? 0 : sell[j - 1]) - prices[i]);
                sell[j] = Math.max(sell[j], buy[j] + prices[i]);
            }
        }
        return sell[k - 1];
    }
}

// Solution 2: DP table — O(n*k) time, O(n*k) space
class Solution2 {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        if (k >= n / 2) {
            int profit = 0;
            for (int i = 1; i < n; i++) {
                if (prices[i] > prices[i - 1]) {
                    profit += prices[i] - prices[i - 1];
                }
            }
            return profit;
        }
        int[][] dp = new int[k + 1][n];
        for (int j = 1; j <= k; j++) {
            int best = -prices[0];
            for (int i = 1; i < n; i++) {
                dp[j][i] = Math.max(dp[j][i - 1], prices[i] + best);
                best = Math.max(best, dp[j - 1][i] - prices[i]);
            }
        }
        return dp[k][n - 1];
    }
}
