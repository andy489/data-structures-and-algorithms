// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/

var maxProfit = function(prices) {
    let profit = 0;
    for (let i = 1; i < prices.length; i++) {
        if (prices[i] > prices[i - 1]) profit += prices[i] - prices[i - 1];
    }
    return profit;
};

var maxProfit2 = function(prices) {
    let profit = 0, i = 0, n = prices.length;
    while (i < n - 1) {
        while (i < n - 1 && prices[i] >= prices[i + 1]) i++;
        const valley = prices[i];
        while (i < n - 1 && prices[i] <= prices[i + 1]) i++;
        profit += prices[i] - valley;
    }
    return profit;
};
