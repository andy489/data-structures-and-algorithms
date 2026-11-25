// https://leetcode.com/problems/regions-cut-by-slashes/

var regionsBySlashes = function(grid) {
    const n = grid.length;
    const g = Array.from({length: n*3}, () => new Array(n*3).fill(0));
    for (let i = 0; i < n; i++) {
        for (let j = 0; j < n; j++) {
            if (grid[i][j] === '/') {
                g[i*3][j*3+2] = g[i*3+1][j*3+1] = g[i*3+2][j*3] = 1;
            } else if (grid[i][j] === '\\') {
                g[i*3][j*3] = g[i*3+1][j*3+1] = g[i*3+2][j*3+2] = 1;
            }
        }
    }
    const dfs = (r, c) => {
        if (r < 0 || r >= n*3 || c < 0 || c >= n*3 || g[r][c]) return;
        g[r][c] = 1;
        dfs(r+1,c); dfs(r-1,c); dfs(r,c+1); dfs(r,c-1);
    };
    let regions = 0;
    for (let i = 0; i < n*3; i++) for (let j = 0; j < n*3; j++) if (!g[i][j]) { dfs(i,j); regions++; }
    return regions;
};
