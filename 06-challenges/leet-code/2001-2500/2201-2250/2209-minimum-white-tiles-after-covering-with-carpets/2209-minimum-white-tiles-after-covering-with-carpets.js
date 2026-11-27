// https://leetcode.com/problems/minimum-white-tiles-after-covering-with-carpets/
var minimumWhiteTiles = function(floor, numCarpets, carpetLen) {
    const n = floor.length;
    const prefix = new Array(n + 1).fill(0);
    for (let i = 0; i < n; i++) {
        prefix[i + 1] = prefix[i] + (floor[i] === '1' ? 1 : 0);
    }
    const INF = Infinity;
    const dp = Array.from({ length: n + 1 }, () => new Array(numCarpets + 1).fill(INF));
    for (let j = 0; j <= numCarpets; j++) {
        dp[0][j] = 0;
    }
    for (let i = 1; i <= n; i++) {
        for (let j = 0; j <= numCarpets; j++) {
            dp[i][j] = dp[i - 1][j] + (floor[i - 1] === '1' ? 1 : 0);
            if (j > 0) {
                const start = Math.max(0, i - carpetLen);
                dp[i][j] = Math.min(dp[i][j], dp[start][j - 1]);
            }
        }
    }
    return dp[n][numCarpets];
};
