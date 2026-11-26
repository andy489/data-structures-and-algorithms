// https://leetcode.com/problems/guess-number-higher-or-lower-ii/

// Solution: Interval DP — O(n³) time, O(n²) space
var getMoneyAmount = function(n) {
    const dp = Array.from({length: n + 2}, () => new Array(n + 2).fill(0));
    for (let len = 2; len <= n; len++) {
        for (let i = 1; i <= n - len + 1; i++) {
            const j = i + len - 1;
            dp[i][j] = Infinity;
            for (let k = i; k <= j; k++) {
                const cost = k + Math.max(
                    k > i ? dp[i][k - 1] : 0,
                    k < j ? dp[k + 1][j] : 0
                );
                dp[i][j] = Math.min(dp[i][j], cost);
            }
        }
    }
    return dp[1][n];
};
