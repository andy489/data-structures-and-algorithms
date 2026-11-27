// https://leetcode.com/problems/maximum-trailing-zeros-in-a-cornered-path/

/**
 * @param {number[][]} grid
 * @return {number}
 */
var maxTrailingZeros = function (grid) {
    const m = grid.length, n = grid[0].length;

    function countFactor(v, p) {
        let cnt = 0;
        while (v % p === 0) { v = Math.floor(v / p); cnt++; }
        return cnt;
    }

    const r2 = Array.from({ length: m }, () => new Array(n + 1).fill(0));
    const r5 = Array.from({ length: m }, () => new Array(n + 1).fill(0));
    const c2 = Array.from({ length: m + 1 }, () => new Array(n).fill(0));
    const c5 = Array.from({ length: m + 1 }, () => new Array(n).fill(0));

    for (let i = 0; i < m; i++) {
        for (let j = 0; j < n; j++) {
            r2[i][j + 1] = r2[i][j] + countFactor(grid[i][j], 2);
            r5[i][j + 1] = r5[i][j] + countFactor(grid[i][j], 5);
        }
    }
    for (let j = 0; j < n; j++) {
        for (let i = 0; i < m; i++) {
            c2[i + 1][j] = c2[i][j] + countFactor(grid[i][j], 2);
            c5[i + 1][j] = c5[i][j] + countFactor(grid[i][j], 5);
        }
    }

    let ans = 0;
    for (let i = 0; i < m; i++) {
        for (let j = 0; j < n; j++) {
            const left2 = r2[i][j + 1], left5 = r5[i][j + 1];
            const right2 = r2[i][n] - r2[i][j], right5 = r5[i][n] - r5[i][j];
            const up2 = c2[i + 1][j], up5 = c5[i + 1][j];
            const down2 = c2[m][j] - c2[i][j], down5 = c5[m][j] - c5[i][j];

            ans = Math.max(ans,
                Math.min(left2 + up2, left5 + up5),
                Math.min(left2 + down2, left5 + down5),
                Math.min(right2 + up2, right5 + up5),
                Math.min(right2 + down2, right5 + down5));
        }
    }
    return ans;
};
