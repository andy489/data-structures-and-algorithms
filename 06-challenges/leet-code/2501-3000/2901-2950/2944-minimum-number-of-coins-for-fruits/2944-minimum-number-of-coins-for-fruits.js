// https://leetcode.com/problems/minimum-number-of-coins-for-fruits/

var minimumCoins = function(prices) {
    const n = prices.length;
    const dp = new Array(n + 1).fill(0);
    const deque = [n]; // sentinel

    for (let i = n - 1; i >= 0; i--) {
        while (deque.length && deque[0] > 2 * i + 2) {
            deque.shift();
        }
        dp[i] = prices[i] + dp[deque[0]];
        while (deque.length && dp[deque[deque.length - 1]] >= dp[i]) {
            deque.pop();
        }
        deque.push(i);
    }

    return dp[0];
};
