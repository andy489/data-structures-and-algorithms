// https://leetcode.com/problems/minimum-operations-to-make-columns-strictly-increasing/
var minimumOperations = function(grid) {
    let ops = 0;
    const m = grid.length, n = grid[0].length;
    for (let j = 0; j < n; j++) {
        let prev = grid[0][j];
        for (let i = 1; i < m; i++) {
            if (grid[i][j] <= prev) {
                ops += prev + 1 - grid[i][j];
                prev = prev + 1;
            } else {
                prev = grid[i][j];
            }
        }
    }
    return ops;
};
