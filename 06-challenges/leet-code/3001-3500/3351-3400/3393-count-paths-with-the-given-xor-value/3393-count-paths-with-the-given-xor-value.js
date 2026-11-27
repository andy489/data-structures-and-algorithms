// https://leetcode.com/problems/count-paths-with-the-given-xor-value/

var countPathsWithXorValue = function(grid, k) {
    const MOD = 1_000_000_007n;
    const m = grid.length, n = grid[0].length;
    const dp = Array.from({length: m}, () =>
        Array.from({length: n}, () => new Array(16).fill(0n))
    );
    dp[0][0][grid[0][0]] = 1n;
    for (let j = 1; j < n; j++) {
        for (let v = 0; v < 16; v++) {
            if (dp[0][j - 1][v] > 0n) {
                dp[0][j][v ^ grid[0][j]] = (dp[0][j][v ^ grid[0][j]] + dp[0][j - 1][v]) % MOD;
            }
        }
    }
    for (let i = 1; i < m; i++) {
        for (let v = 0; v < 16; v++) {
            if (dp[i - 1][0][v] > 0n) {
                dp[i][0][v ^ grid[i][0]] = (dp[i][0][v ^ grid[i][0]] + dp[i - 1][0][v]) % MOD;
            }
        }
    }
    for (let i = 1; i < m; i++) {
        for (let j = 1; j < n; j++) {
            for (let v = 0; v < 16; v++) {
                const nxt = v ^ grid[i][j];
                dp[i][j][nxt] = (dp[i][j][nxt] + dp[i - 1][j][v] + dp[i][j - 1][v]) % MOD;
            }
        }
    }
    return Number(dp[m - 1][n - 1][k]);
};
