// https://leetcode.com/problems/k-highest-ranked-items-within-a-price-range/
var highestRankedKItems = function(grid, pricing, start, k) {
    const m = grid.length;
    const n = grid[0].length;
    const [low, high] = pricing;
    const candidates = [];
    const visited = Array.from({length: m}, () => new Array(n).fill(false));
    const queue = [[start[0], start[1], 0]];
    visited[start[0]][start[1]] = true;
    const dirs = [[0,1],[0,-1],[1,0],[-1,0]];
    let head = 0;

    while (head < queue.length) {
        const [r, c, dist] = queue[head++];
        const price = grid[r][c];
        if (price >= low && price <= high) {
            candidates.push([dist, price, r, c]);
        }
        for (const [dr, dc] of dirs) {
            const nr = r + dr;
            const nc = c + dc;
            if (nr >= 0 && nr < m && nc >= 0 && nc < n && !visited[nr][nc] && grid[nr][nc] !== 0) {
                visited[nr][nc] = true;
                queue.push([nr, nc, dist + 1]);
            }
        }
    }

    candidates.sort((a, b) => {
        if (a[0] !== b[0]) { return a[0] - b[0]; }
        if (a[1] !== b[1]) { return a[1] - b[1]; }
        if (a[2] !== b[2]) { return a[2] - b[2]; }
        return a[3] - b[3];
    });

    return candidates.slice(0, k).map(([, , r, c]) => [r, c]);
};
