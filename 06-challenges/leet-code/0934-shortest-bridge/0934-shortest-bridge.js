// https://leetcode.com/problems/shortest-bridge/

var shortestBridge = function(grid) {
    const n = grid.length;
    const q = [];
    const dfs = (r, c) => {
        if (r < 0 || r >= n || c < 0 || c >= n || grid[r][c] !== 1) return;
        grid[r][c] = 2; q.push([r, c]);
        dfs(r+1,c); dfs(r-1,c); dfs(r,c+1); dfs(r,c-1);
    };
    let found = false;
    outer: for (let i = 0; i < n; i++) for (let j = 0; j < n; j++) if (grid[i][j] === 1) { dfs(i, j); found = true; break outer; }
    const dirs = [[0,1],[0,-1],[1,0],[-1,0]];
    let steps = 0, qi = 0;
    while (qi < q.length) {
        const size = q.length - qi;
        for (let s = 0; s < size; s++) {
            const [r, c] = q[qi++];
            for (const [dr, dc] of dirs) {
                const nr = r+dr, nc = c+dc;
                if (nr<0||nr>=n||nc<0||nc>=n) continue;
                if (grid[nr][nc] === 1) return steps;
                if (grid[nr][nc] === 0) { grid[nr][nc] = 2; q.push([nr, nc]); }
            }
        }
        steps++;
    }
    return -1;
};
