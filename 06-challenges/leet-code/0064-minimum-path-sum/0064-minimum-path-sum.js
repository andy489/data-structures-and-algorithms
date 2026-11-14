// https://leetcode.com/problems/minimum-path-sum/

var minPathSum = function(grid) {
    const m = grid.length, n = grid[0].length;
    const dp = new Array(n).fill(0);
    dp[0] = grid[0][0];
    for (let j = 1; j < n; j++) {
        dp[j] = dp[j - 1] + grid[0][j];
    }
    for (let i = 1; i < m; i++) {
        dp[0] += grid[i][0];
        for (let j = 1; j < n; j++) {
            dp[j] = grid[i][j] + Math.min(dp[j], dp[j - 1]);
        }
    }
    return dp[n - 1];
};
