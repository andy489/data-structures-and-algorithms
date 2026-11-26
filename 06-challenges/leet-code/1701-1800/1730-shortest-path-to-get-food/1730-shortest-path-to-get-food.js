// https://leetcode.com/problems/shortest-path-to-get-food/

var getFood = function(grid) {
    const m = grid.length, n = grid[0].length;
    const dirs = [[0,1],[0,-1],[1,0],[-1,0]];
    let sr = 0, sc = 0;
    for (let i = 0; i < m; i++) {
        for (let j = 0; j < n; j++) {
            if (grid[i][j] === '*') { sr = i; sc = j; }
        }
    }
    const queue = [[sr, sc, 0]];
    grid[sr][sc] = 'X';
    for (let head = 0; head < queue.length; head++) {
        const [r, c, dist] = queue[head];
        for (const [dr, dc] of dirs) {
            const nr = r + dr, nc = c + dc;
            if (nr < 0 || nr >= m || nc < 0 || nc >= n || grid[nr][nc] === 'X') { continue; }
            if (grid[nr][nc] === '#') { return dist + 1; }
            grid[nr][nc] = 'X';
            queue.push([nr, nc, dist + 1]);
        }
    }
    return -1;
};
