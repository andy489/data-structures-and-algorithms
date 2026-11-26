// https://leetcode.com/problems/shift-2d-grid/

var shiftGrid = function(grid, k) {
    const m = grid.length, n = grid[0].length;
    const flat = grid.flat(), total = m * n;
    k %= total;
    const shifted = [...flat.slice(total-k), ...flat.slice(0, total-k)];
    const res = [];
    for (let i = 0; i < m; i++) res.push(shifted.slice(i*n, (i+1)*n));
    return res;
};
