// https://leetcode.com/problems/maximum-non-negative-product-in-a-matrix/

var maxProductPath = function(grid) {
    const MOD = BigInt(1e9 + 7);
    const m = grid.length, n = grid[0].length;
    const dpMax = Array.from({length: m}, () => new Array(n).fill(0n));
    const dpMin = Array.from({length: m}, () => new Array(n).fill(0n));
    dpMax[0][0] = dpMin[0][0] = BigInt(grid[0][0]);
    for (let i = 1; i < m; i++) dpMax[i][0] = dpMin[i][0] = dpMax[i - 1][0] * BigInt(grid[i][0]);
    for (let j = 1; j < n; j++) dpMax[0][j] = dpMin[0][j] = dpMax[0][j - 1] * BigInt(grid[0][j]);
    for (let i = 1; i < m; i++) {
        for (let j = 1; j < n; j++) {
            const v = BigInt(grid[i][j]);
            const candidates = [
                dpMax[i - 1][j] * v, dpMin[i - 1][j] * v,
                dpMax[i][j - 1] * v, dpMin[i][j - 1] * v,
            ];
            dpMax[i][j] = candidates.reduce((a, b) => a > b ? a : b);
            dpMin[i][j] = candidates.reduce((a, b) => a < b ? a : b);
        }
    }
    const ans = dpMax[m - 1][n - 1];
    return ans < 0n ? -1 : Number(ans % MOD);
};
