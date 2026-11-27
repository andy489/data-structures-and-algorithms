// https://leetcode.com/problems/unique-paths-ii/

var uniquePathsWithObstacles = function(obstacleGrid) {
    const m = obstacleGrid.length, n = obstacleGrid[0].length;
    const dp = new Array(n).fill(0);
    dp[0] = obstacleGrid[0][0] === 0 ? 1 : 0;
    for (let j = 1; j < n; j++) {
        dp[j] = obstacleGrid[0][j] === 0 ? dp[j - 1] : 0;
    }
    for (let i = 1; i < m; i++) {
        if (obstacleGrid[i][0] === 1) {
            dp[0] = 0;
        }
        for (let j = 1; j < n; j++) {
            dp[j] = obstacleGrid[i][j] === 0 ? dp[j] + dp[j - 1] : 0;
        }
    }
    return dp[n - 1];
};
