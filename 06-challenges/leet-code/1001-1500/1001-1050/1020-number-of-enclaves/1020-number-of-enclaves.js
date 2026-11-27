// https://leetcode.com/problems/number-of-enclaves/

var numEnclaves = function(grid) {
    const m = grid.length, n = grid[0].length;
    const flood = (r, c) => {
        if (r < 0 || r >= m || c < 0 || c >= n || grid[r][c] !== 1) return;
        grid[r][c] = 0;
        flood(r+1,c); flood(r-1,c); flood(r,c+1); flood(r,c-1);
    };
    for (let i = 0; i < m; i++) { flood(i, 0); flood(i, n-1); }
    for (let j = 0; j < n; j++) { flood(0, j); flood(m-1, j); }
    return grid.reduce((s, row) => s + row.reduce((a, v) => a + v, 0), 0);
};
