// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/

var maxProfit = function(prices) {
    let held = -prices[0], sold = 0, rest = 0;
    for (let i = 1; i < prices.length; i++) {
        [held, sold, rest] = [Math.max(held, rest - prices[i]), held + prices[i], Math.max(rest, sold)];
    }
    return Math.max(sold, rest);
};
