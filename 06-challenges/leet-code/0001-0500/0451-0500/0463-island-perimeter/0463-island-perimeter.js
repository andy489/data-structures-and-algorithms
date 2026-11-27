// https://leetcode.com/problems/island-perimeter/

var islandPerimeter = function(grid) {
    const rows = grid.length, cols = grid[0].length;
    let perimeter = 0;
    for (let r = 0; r < rows; r++) {
        for (let c = 0; c < cols; c++) {
            if (grid[r][c] === 1) {
                perimeter += 4;
                if (c + 1 < cols && grid[r][c + 1] === 1) {
                    perimeter -= 2;
                }
                if (r + 1 < rows && grid[r + 1][c] === 1) {
                    perimeter -= 2;
                }
            }
        }
    }
    return perimeter;
};
