/**
 * @param {number} m
 * @param {number} n
 * @param {number} maxMove
 * @param {number} startRow
 * @param {number} startColumn
 * @return {number}
 */
var findPaths = function (m, n, maxMove, startRow, startColumn) {
    const MOD = 1_000_000_007n;
    let dp = Array.from({ length: m }, () => new Array(n).fill(0n));
    dp[startRow][startColumn] = 1n;
    let ans = 0n;
    const dirs = [[0, 1], [0, -1], [1, 0], [-1, 0]];
    for (let move = 0; move < maxMove; move++) {
        const nxt = Array.from({ length: m }, () => new Array(n).fill(0n));
        for (let i = 0; i < m; i++) {
            for (let j = 0; j < n; j++) {
                if (dp[i][j] === 0n) {
                    continue;
                }
                for (const [di, dj] of dirs) {
                    const ni = i + di, nj = j + dj;
                    if (ni < 0 || ni >= m || nj < 0 || nj >= n) {
                        ans = (ans + dp[i][j]) % MOD;
                    } else {
                        nxt[ni][nj] = (nxt[ni][nj] + dp[i][j]) % MOD;
                    }
                }
            }
        }
        dp = nxt;
    }
    return Number(ans);
};
