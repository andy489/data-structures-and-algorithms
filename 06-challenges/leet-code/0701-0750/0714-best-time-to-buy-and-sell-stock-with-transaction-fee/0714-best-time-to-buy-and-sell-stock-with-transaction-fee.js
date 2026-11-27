// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/

var maxProfit = function(prices, fee) {
    let hold = -prices[0], free = 0;
    for (let i = 1; i < prices.length; i++) {
        const newHold = Math.max(hold, free - prices[i]);
        const newFree = Math.max(free, hold + prices[i] - fee);
        hold = newHold;
        free = newFree;
    }
    return free;
};
