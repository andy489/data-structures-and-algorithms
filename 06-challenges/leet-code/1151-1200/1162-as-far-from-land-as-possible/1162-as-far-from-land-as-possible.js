// https://leetcode.com/problems/as-far-from-land-as-possible/

var maxDistance = function(grid) {
    const n = grid.length;
    const q = [];
    for (let r = 0; r < n; r++) {
        for (let c = 0; c < n; c++) {
            if (grid[r][c] === 1) {
                q.push([r, c]);
            }
        }
    }
    if (q.length === 0 || q.length === n * n) {
        return -1;
    }
    const dirs = [[-1, 0], [1, 0], [0, -1], [0, 1]];
    let dist = -1, head = 0;
    while (head < q.length) {
        const [r, c] = q[head++];
        for (const [dr, dc] of dirs) {
            const [nr, nc] = [r + dr, c + dc];
            if (nr >= 0 && nr < n && nc >= 0 && nc < n && grid[nr][nc] === 0) {
                grid[nr][nc] = grid[r][c] + 1;
                dist = grid[nr][nc] - 1;
                q.push([nr, nc]);
            }
        }
    }
    return dist;
};
