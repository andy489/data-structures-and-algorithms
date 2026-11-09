// https://leetcode.com/problems/minimum-cost-to-merge-stones/

// Solution: Interval DP with Prefix Sums — O(n³/k) time, O(n²) space
var mergeStones = function(stones, k) {
    const n = stones.length;
    if ((n - 1) % (k - 1) !== 0) {
        return -1;
    }

    const prefix = new Array(n + 1).fill(0);
    for (let i = 0; i < n; i++) {
        prefix[i + 1] = prefix[i] + stones[i];
    }

    const dp = Array.from({ length: n }, () => new Array(n).fill(0));

    for (let len = k; len <= n; len++) {
        for (let i = 0; i <= n - len; i++) {
            const j = i + len - 1;
            dp[i][j] = Infinity;
            for (let m = i; m < j; m += k - 1) {
                dp[i][j] = Math.min(dp[i][j], dp[i][m] + dp[m + 1][j]);
            }
            if ((j - i) % (k - 1) === 0) {
                dp[i][j] += prefix[j + 1] - prefix[i];
            }
        }
    }

    return dp[0][n - 1];
};
