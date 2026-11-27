// https://leetcode.com/problems/perfect-squares/

// Solution: Dynamic Programming — O(n √n) time, O(n) space
var numSquares = function(n) {
    const dp = new Array(n + 1).fill(Infinity);
    dp[0] = 0;
    for (let i = 1; i <= n; i++) {
        for (let j = 1; j * j <= i; j++) {
            dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
        }
    }
    return dp[n];
};
