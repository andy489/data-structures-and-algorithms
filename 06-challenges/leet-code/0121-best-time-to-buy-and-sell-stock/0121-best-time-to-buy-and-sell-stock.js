// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/

var maxProfit = function(prices) {
    let minPrice = Infinity, maxProfit = 0;
    for (const price of prices) {
        minPrice  = Math.min(minPrice, price);
        maxProfit = Math.max(maxProfit, price - minPrice);
    }
    return maxProfit;
};

var maxProfit2 = function(prices) {
    let currentGain = 0, maxProfit = 0;
    for (let i = 1; i < prices.length; i++) {
        currentGain = Math.max(0, currentGain + prices[i] - prices[i - 1]);
        maxProfit   = Math.max(maxProfit, currentGain);
    }
    return maxProfit;
};
