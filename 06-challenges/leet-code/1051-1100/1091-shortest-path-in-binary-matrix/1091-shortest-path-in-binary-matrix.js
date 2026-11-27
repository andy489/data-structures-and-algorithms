// https://leetcode.com/problems/shortest-path-in-binary-matrix/

var shortestPathBinaryMatrix = function(grid) {
    const n = grid.length;
    if (grid[0][0] || grid[n-1][n-1]) return -1;
    if (n === 1) return 1;
    const q = [[0, 0, 1]];
    grid[0][0] = 1;
    const dirs = [[-1,-1],[-1,0],[-1,1],[0,-1],[0,1],[1,-1],[1,0],[1,1]];
    for (let i = 0; i < q.length; i++) {
        const [r, c, dist] = q[i];
        for (const [dr, dc] of dirs) {
            const [nr, nc] = [r+dr, c+dc];
            if (nr<0||nr>=n||nc<0||nc>=n||grid[nr][nc]) continue;
            if (nr===n-1&&nc===n-1) return dist+1;
            grid[nr][nc] = 1;
            q.push([nr, nc, dist+1]);
        }
    }
    return -1;
};
