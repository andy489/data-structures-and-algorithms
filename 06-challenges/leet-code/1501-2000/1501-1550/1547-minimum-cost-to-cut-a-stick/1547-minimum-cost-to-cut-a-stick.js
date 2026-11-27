// https://leetcode.com/problems/minimum-cost-to-cut-a-stick/

var minCost = function(n, cuts) {
    cuts.sort((a, b) => a - b);
    const c = [0, ...cuts, n];
    const m = c.length;
    const dp = Array.from({length: m}, () => new Array(m).fill(0));
    for (let len = 2; len < m; len++) {
        for (let left = 0; left + len < m; left++) {
            const right = left + len;
            dp[left][right] = Infinity;
            for (let mid = left + 1; mid < right; mid++) {
                dp[left][right] = Math.min(dp[left][right],
                    dp[left][mid] + dp[mid][right] + c[right] - c[left]);
            }
        }
    }
    return dp[0][m - 1];
};
