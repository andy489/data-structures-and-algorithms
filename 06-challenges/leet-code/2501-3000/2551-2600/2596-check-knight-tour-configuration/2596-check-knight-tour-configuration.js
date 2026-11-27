// https://leetcode.com/problems/check-knight-tour-configuration/
/**
 * @param {number[][]} grid
 * @return {boolean}
 */
var checkValidGrid = function(grid) {
    if (grid[0][0] !== 0) {
        return false;
    }
    const n = grid.length;
    const rows = new Array(n * n);
    const cols = new Array(n * n);
    for (let r = 0; r < n; r++) {
        for (let c = 0; c < n; c++) {
            rows[grid[r][c]] = r;
            cols[grid[r][c]] = c;
        }
    }
    for (let m = 0; m < n * n - 1; m++) {
        const dr = Math.abs(rows[m + 1] - rows[m]);
        const dc = Math.abs(cols[m + 1] - cols[m]);
        if (!((dr === 1 && dc === 2) || (dr === 2 && dc === 1))) {
            return false;
        }
    }
    return true;
};
