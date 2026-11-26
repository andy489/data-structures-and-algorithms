// https://leetcode.com/problems/making-a-large-island/

var largestIsland = function(grid) {
    const n = grid.length;
    const islandSize = new Map();
    let islandId = 2;
    const dirs = [[0,1],[0,-1],[1,0],[-1,0]];

    function dfs(r, c, id) {
        if (r < 0 || r >= n || c < 0 || c >= n || grid[r][c] !== 1) { return 0; }
        grid[r][c] = id;
        let size = 1;
        for (const [dr, dc] of dirs) { size += dfs(r+dr, c+dc, id); }
        return size;
    }

    let max = 0;
    for (let r = 0; r < n; r++) {
        for (let c = 0; c < n; c++) {
            if (grid[r][c] === 1) {
                const size = dfs(r, c, islandId);
                islandSize.set(islandId, size);
                max = Math.max(max, size);
                islandId++;
            }
        }
    }
    for (let r = 0; r < n; r++) {
        for (let c = 0; c < n; c++) {
            if (grid[r][c] === 0) {
                const seen = new Set();
                for (const [dr, dc] of dirs) {
                    const nr = r+dr, nc = c+dc;
                    if (nr >= 0 && nr < n && nc >= 0 && nc < n && grid[nr][nc] > 1) {
                        seen.add(grid[nr][nc]);
                    }
                }
                let size = 1;
                for (const id of seen) { size += islandSize.get(id); }
                max = Math.max(max, size);
            }
        }
    }
    return max;
};
