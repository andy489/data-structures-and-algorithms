// https://leetcode.com/problems/swim-in-rising-water/

var swimInWater = function(grid) {
    const n = grid.length;
    const dirs = [[0,1],[0,-1],[1,0],[-1,0]];
    const heap = [[grid[0][0], 0, 0]];
    const visited = Array.from({length: n}, () => new Array(n).fill(false));
    while (heap.length) {
        heap.sort((a, b) => a[0] - b[0]);
        const [t, r, c] = heap.shift();
        if (visited[r][c]) continue;
        visited[r][c] = true;
        if (r === n - 1 && c === n - 1) return t;
        for (const [dr, dc] of dirs) {
            const nr = r + dr, nc = c + dc;
            if (nr >= 0 && nr < n && nc >= 0 && nc < n && !visited[nr][nc]) {
                heap.push([Math.max(t, grid[nr][nc]), nr, nc]);
            }
        }
    }
    return -1;
};
