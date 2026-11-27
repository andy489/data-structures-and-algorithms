// https://leetcode.com/problems/unique-binary-search-trees/

// Solution: Dynamic Programming (Catalan Number) — O(n²) time, O(n) space
var numTrees = function(n) {
    const dp = new Array(n + 1).fill(0);
    dp[0] = dp[1] = 1;
    for (let k = 2; k <= n; k++) {
        for (let i = 1; i <= k; i++) {
            dp[k] += dp[i - 1] * dp[k - i];
        }
    }
    return dp[n];
};
