// https://leetcode.com/problems/multi-source-flood-fill/
/**
 * @param {number} n
 * @param {number} m
 * @param {number[][]} sources
 * @return {number[][]}
 */
var floodFill = function(n, m, sources) {
    const grid = Array.from({length: n}, () => new Array(m).fill(0));
    const dist = Array.from({length: n}, () => new Array(m).fill(-1));
    const queue = [];
    for (const [r, c, color] of sources) {
        grid[r][c] = color;
        dist[r][c] = 0;
        queue.push([r, c]);
    }
    const dirs = [[-1,0],[1,0],[0,-1],[0,1]];
    let head = 0;
    while (head < queue.length) {
        const [r, c] = queue[head++];
        for (const [dr, dc] of dirs) {
            const nr = r + dr, nc = c + dc;
            if (nr < 0 || nr >= n || nc < 0 || nc >= m) {
                continue;
            }
            const newDist = dist[r][c] + 1;
            if (dist[nr][nc] === -1) {
                dist[nr][nc] = newDist;
                grid[nr][nc] = grid[r][c];
                queue.push([nr, nc]);
            } else if (dist[nr][nc] === newDist) {
                grid[nr][nc] = Math.max(grid[nr][nc], grid[r][c]);
            }
        }
    }
    return grid;
};
