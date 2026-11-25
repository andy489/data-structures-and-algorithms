// https://leetcode.com/problems/surface-area-of-3d-shapes/

var surfaceArea = function(grid) {
    const n = grid.length;
    let ans = 0;
    for (let i = 0; i < n; i++) {
        for (let j = 0; j < n; j++) {
            if (grid[i][j]) ans += 4 * grid[i][j] + 2;
            if (i > 0) ans -= 2 * Math.min(grid[i][j], grid[i-1][j]);
            if (j > 0) ans -= 2 * Math.min(grid[i][j], grid[i][j-1]);
        }
    }
    return ans;
};
