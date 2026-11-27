// https://leetcode.com/problems/shortest-path-to-get-all-keys/

var shortestPathAllKeys = function(grid) {
    const m = grid.length, n = grid[0].length;
    let startR = 0, startC = 0, allKeys = 0;
    for (let r = 0; r < m; r++) {
        for (let c = 0; c < n; c++) {
            const ch = grid[r][c];
            if (ch === '@') { startR = r; startC = c; }
            else if (ch >= 'a' && ch <= 'f') allKeys |= 1 << (ch.charCodeAt(0) - 97);
        }
    }
    const queue = [[startR, startC, 0, 0]];
    const visited = new Set([`${startR},${startC},0`]);
    const dirs = [[0,1],[0,-1],[1,0],[-1,0]];
    for (let i = 0; i < queue.length; i++) {
        const [r, c, keys, steps] = queue[i];
        if (keys === allKeys) return steps;
        for (const [dr, dc] of dirs) {
            const nr = r + dr, nc = c + dc;
            if (nr < 0 || nr >= m || nc < 0 || nc >= n) continue;
            const ch = grid[nr][nc];
            if (ch === '#') continue;
            if (ch >= 'A' && ch <= 'F' && !(keys & (1 << (ch.charCodeAt(0) - 65)))) continue;
            const nkeys = (ch >= 'a' && ch <= 'f') ? keys | (1 << (ch.charCodeAt(0) - 97)) : keys;
            const state = `${nr},${nc},${nkeys}`;
            if (!visited.has(state)) {
                visited.add(state);
                queue.push([nr, nc, nkeys, steps + 1]);
            }
        }
    }
    return -1;
};
