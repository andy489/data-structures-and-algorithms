// https://leetcode.com/problems/max-increase-to-keep-city-skyline/

var maxIncreaseKeepingSkyline = function(grid) {
    const n = grid.length;
    const rowMax = grid.map(row => Math.max(...row));
    const colMax = Array.from({length: n}, (_, j) => Math.max(...grid.map(row => row[j])));
    let total = 0;
    for (let i = 0; i < n; i++) {
        for (let j = 0; j < n; j++) {
            total += Math.min(rowMax[i], colMax[j]) - grid[i][j];
        }
    }
    return total;
};
