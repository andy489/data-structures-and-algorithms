// https://leetcode.com/problems/minimum-cost-to-split-into-ones/

/**
 * @param {number} n
 * @return {number}
 */
var minimumCost = function(n) {
    const dp = new Array(n + 1).fill(0);
    for (let x = 2; x <= n; x++) {
        dp[x] = Infinity;
        for (let a = 1; a < x; a++) {
            const b = x - a;
            const cost = a * b + dp[a] + dp[b];
            dp[x] = Math.min(dp[x], cost);
        }
    }
    return dp[n];
};
