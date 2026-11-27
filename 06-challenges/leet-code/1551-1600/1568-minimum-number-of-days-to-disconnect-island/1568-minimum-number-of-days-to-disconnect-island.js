// https://leetcode.com/problems/minimum-number-of-days-to-disconnect-island/

var minDays = function(grid) {
    const m = grid.length, n = grid[0].length;

    const countIslands = () => {
        const visited = Array.from({length: m}, () => new Array(n).fill(false));
        let count = 0;
        for (let i = 0; i < m; i++) {
            for (let j = 0; j < n; j++) {
                if (grid[i][j] === 1 && !visited[i][j]) {
                    flood(visited, i, j);
                    count++;
                }
            }
        }
        return count;
    };

    const flood = (vis, i, j) => {
        vis[i][j] = true;
        for (const [di, dj] of [[0,1],[0,-1],[1,0],[-1,0]]) {
            const ni = i + di, nj = j + dj;
            if (ni >= 0 && ni < m && nj >= 0 && nj < n && grid[ni][nj] === 1 && !vis[ni][nj]) {
                flood(vis, ni, nj);
            }
        }
    };

    if (countIslands() !== 1) {
        return 0;
    }

    for (let i = 0; i < m; i++) {
        for (let j = 0; j < n; j++) {
            if (grid[i][j] === 1) {
                grid[i][j] = 0;
                if (countIslands() !== 1) {
                    grid[i][j] = 1;
                    return 1;
                }
                grid[i][j] = 1;
            }
        }
    }
    return 2;
};
