// https://leetcode.com/problems/minimum-cost-to-merge-stones/

// Solution: Interval DP with Prefix Sums — O(n³/k) time, O(n²) space
var mergeStones = function(stones, k) {
    const n = stones.length;
    // each merge reduces pile count by (k-1); need (n-1) total reductions
    if ((n - 1) % (k - 1) !== 0) {
        return -1;
    }

    // prefix[i+1] = sum of stones[0..i] for O(1) range sum queries
    const prefix = new Array(n + 1).fill(0);
    for (let i = 0; i < n; i++) {
        prefix[i + 1] = prefix[i] + stones[i];
    }

    // dp[i][j] = min cost to reduce stones[i..j] to the minimum possible piles
    const dp = Array.from({ length: n }, () => new Array(n).fill(0));

    for (let len = k; len <= n; len++) {
        for (let i = 0; i <= n - len; i++) {
            const j = i + len - 1;
            dp[i][j] = Infinity;
            // step by (k-1): left part stones[i..m] must be reducible to 1 pile,
            // which requires (m-i) % (k-1) == 0, so m = i, i+(k-1), i+2(k-1), ...
            for (let m = i; m < j; m += k - 1) {
                dp[i][j] = Math.min(dp[i][j], dp[i][m] + dp[m + 1][j]);
            }
            // if stones[i..j] can be reduced to exactly 1 pile, add the final merge cost
            if ((j - i) % (k - 1) === 0) {
                dp[i][j] += prefix[j + 1] - prefix[i];
            }
        }
    }

    return dp[0][n - 1];
};
