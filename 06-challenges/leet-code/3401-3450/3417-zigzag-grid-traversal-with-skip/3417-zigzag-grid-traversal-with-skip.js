// https://leetcode.com/problems/zigzag-grid-traversal-with-skip/

/**
 * @param {number[][]} grid
 * @return {number[]}
 */
var zigzagTraversal = function(grid) {
    const m = grid.length, n = grid[0].length;
    const result = [];
    let skip = 0;
    for (let i = 0; i < m; i++) {
        if (i % 2 === 0) {
            for (let j = 0; j < n; j++) {
                if (skip % 2 === 0) result.push(grid[i][j]);
                skip++;
            }
        } else {
            for (let j = n - 1; j >= 0; j--) {
                if (skip % 2 === 0) result.push(grid[i][j]);
                skip++;
            }
        }
    }
    return result;
};
