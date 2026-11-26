// https://leetcode.com/problems/unique-paths-iii/

var uniquePathsIII = function(grid) {
    const m = grid.length, n = grid[0].length;
    let total = 0, sr = 0, sc = 0;
    for (let i = 0; i < m; i++) for (let j = 0; j < n; j++) {
        if (grid[i][j] !== -1) total++;
        if (grid[i][j] === 1) { sr = i; sc = j; }
    }
    let ans = 0;
    const dfs = (r, c, visited) => {
        if (grid[r][c] === 2) { if (visited === total - 1) ans++; return; }
        const orig = grid[r][c];
        grid[r][c] = -1;
        for (const [dr, dc] of [[0,1],[0,-1],[1,0],[-1,0]]) {
            const [nr, nc] = [r+dr, c+dc];
            if (nr >= 0 && nr < m && nc >= 0 && nc < n && grid[nr][nc] !== -1) dfs(nr, nc, visited+1);
        }
        grid[r][c] = orig;
    };
    dfs(sr, sc, 0);
    return ans;
};
