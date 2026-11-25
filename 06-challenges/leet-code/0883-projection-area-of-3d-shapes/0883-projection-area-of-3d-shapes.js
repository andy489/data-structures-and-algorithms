// https://leetcode.com/problems/projection-area-of-3d-shapes/

var projectionArea = function(grid) {
    const n = grid.length;
    let xy = 0, yz = 0, zx = 0;
    for (let i = 0; i < n; i++) {
        let rowMax = 0, colMax = 0;
        for (let j = 0; j < n; j++) {
            if (grid[i][j] > 0) xy++;
            rowMax = Math.max(rowMax, grid[i][j]);
            colMax = Math.max(colMax, grid[j][i]);
        }
        yz += rowMax; zx += colMax;
    }
    return xy + yz + zx;
};
