// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/

// Solution 1: Rolling buy/sell arrays — O(n*k) time, O(k) space
var maxProfit = function(k, prices) {
    const n = prices.length;
    if (k >= Math.floor(n / 2)) {
        let profit = 0;
        for (let i = 1; i < n; i++) {
            if (prices[i] > prices[i - 1]) profit += prices[i] - prices[i - 1];
        }
        return profit;
    }
    const buy = new Array(k).fill(-prices[0]);
    const sell = new Array(k).fill(0);
    for (let i = 1; i < n; i++) {
        for (let j = 0; j < k; j++) {
            buy[j] = Math.max(buy[j], (j === 0 ? 0 : sell[j - 1]) - prices[i]);
            sell[j] = Math.max(sell[j], buy[j] + prices[i]);
        }
    }
    return sell[k - 1];
};

// Solution 2: DP table — O(n*k) time, O(n*k) space
var maxProfit2 = function(k, prices) {
    const n = prices.length;
    if (k >= Math.floor(n / 2)) {
        let profit = 0;
        for (let i = 1; i < n; i++) {
            if (prices[i] > prices[i - 1]) profit += prices[i] - prices[i - 1];
        }
        return profit;
    }
    const dp = Array.from({ length: k + 1 }, () => new Array(n).fill(0));
    for (let j = 1; j <= k; j++) {
        let best = -prices[0];
        for (let i = 1; i < n; i++) {
            dp[j][i] = Math.max(dp[j][i - 1], prices[i] + best);
            best = Math.max(best, dp[j - 1][i] - prices[i]);
        }
    }
    return dp[k][n - 1];
};
