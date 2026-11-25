// https://leetcode.com/problems/bricks-falling-when-hit/

var hitBricks = function(grid, hits) {
    const m = grid.length, n = grid[0].length;
    const copy = grid.map(row => [...row]);
    for (const [r, c] of hits) {
        copy[r][c] = 0;
    }

    const roof = m * n;
    const parent = Array.from({length: m * n + 1}, (_, i) => i);
    const size = new Array(m * n + 1).fill(1);

    function find(x) {
        while (parent[x] !== x) {
            parent[x] = parent[parent[x]];
            x = parent[x];
        }
        return x;
    }

    function union(x, y) {
        let px = find(x), py = find(y);
        if (px === py) { return; }
        if (size[px] < size[py]) { [px, py] = [py, px]; }
        parent[py] = px;
        size[px] += size[py];
    }

    for (let r = 0; r < m; r++) {
        for (let c = 0; c < n; c++) {
            if (copy[r][c] === 1) {
                if (r === 0) { union(r * n + c, roof); }
                if (r > 0 && copy[r - 1][c] === 1) { union(r * n + c, (r - 1) * n + c); }
                if (c > 0 && copy[r][c - 1] === 1) { union(r * n + c, r * n + c - 1); }
            }
        }
    }

    const dirs = [[0,1],[0,-1],[1,0],[-1,0]];
    const result = new Array(hits.length).fill(0);
    for (let i = hits.length - 1; i >= 0; i--) {
        const [r, c] = hits[i];
        if (grid[r][c] === 0) { continue; }
        const prevRoof = size[find(roof)];
        copy[r][c] = 1;
        if (r === 0) { union(r * n + c, roof); }
        for (const [dr, dc] of dirs) {
            const nr = r + dr, nc = c + dc;
            if (nr >= 0 && nr < m && nc >= 0 && nc < n && copy[nr][nc] === 1) {
                union(r * n + c, nr * n + nc);
            }
        }
        result[i] = Math.max(0, size[find(roof)] - prevRoof - 1);
    }
    return result;
};
