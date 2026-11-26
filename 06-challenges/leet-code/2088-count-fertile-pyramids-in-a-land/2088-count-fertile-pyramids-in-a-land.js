// https://leetcode.com/problems/count-fertile-pyramids-in-a-land/

// Solution: DP — O(mn) time, O(mn) space
var countPyramids = function(grid) {
    const m = grid.length, n = grid[0].length;
    const dp = Array.from({length: m}, () => new Array(n).fill(0));
    let res = 0;
    for (let i = m-1; i >= 0; i--) {
        for (let j = 0; j < n; j++) {
            if (!grid[i][j]) { dp[i][j] = 0; continue; }
            if (i === m-1 || j === 0 || j === n-1) dp[i][j] = 1;
            else dp[i][j] = Math.min(dp[i+1][j-1], dp[i+1][j], dp[i+1][j+1]) + 1;
            res += dp[i][j] - 1;
        }
    }
    for (let i = 0; i < m; i++) {
        for (let j = 0; j < n; j++) {
            if (!grid[i][j]) { dp[i][j] = 0; continue; }
            if (i === 0 || j === 0 || j === n-1) dp[i][j] = 1;
            else dp[i][j] = Math.min(dp[i-1][j-1], dp[i-1][j], dp[i-1][j+1]) + 1;
            res += dp[i][j] - 1;
        }
    }
    return res;
};
