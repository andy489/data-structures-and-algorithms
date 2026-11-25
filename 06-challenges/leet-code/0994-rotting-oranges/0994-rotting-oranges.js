// https://leetcode.com/problems/rotting-oranges/

var orangesRotting = function(grid) {
    const m = grid.length, n = grid[0].length;
    const queue = [];
    let fresh = 0;
    for (let i = 0; i < m; i++) for (let j = 0; j < n; j++) {
        if (grid[i][j] === 2) queue.push([i, j]);
        else if (grid[i][j] === 1) fresh++;
    }
    let minutes = 0, qi = 0;
    while (qi < queue.length && fresh) {
        minutes++;
        const size = queue.length;
        for (; qi < size; qi++) {
            const [r, c] = queue[qi];
            for (const [dr, dc] of [[0,1],[0,-1],[1,0],[-1,0]]) {
                const [nr, nc] = [r+dr, c+dc];
                if (nr >= 0 && nr < m && nc >= 0 && nc < n && grid[nr][nc] === 1) {
                    grid[nr][nc] = 2; fresh--; queue.push([nr, nc]);
                }
            }
        }
    }
    return fresh === 0 ? minutes : -1;
};
