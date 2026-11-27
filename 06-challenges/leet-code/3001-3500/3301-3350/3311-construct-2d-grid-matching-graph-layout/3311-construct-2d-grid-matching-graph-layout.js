// https://leetcode.com/problems/construct-2d-grid-matching-graph-layout/

/**
 * @param {number} n
 * @param {number[][]} edges
 * @return {number[][]}
 */
var constructGridLayout = function (n, edges) {
    const adj = Array.from({ length: n }, () => new Set());
    for (const [u, v] of edges) {
        adj[u].add(v);
        adj[v].add(u);
    }
    const deg = Array.from({ length: n }, (_, i) => adj[i].size);
    const minDeg = Math.min(...deg);

    let start = deg.indexOf(minDeg);

    if (minDeg === 1) {
        const row = [start];
        const placed = new Set([start]);
        while (true) {
            const cur = row[row.length - 1];
            let nxt = -1;
            for (const nb of adj[cur]) {
                if (!placed.has(nb)) {
                    nxt = nb;
                    break;
                }
            }
            if (nxt === -1) {
                break;
            }
            row.push(nxt);
            placed.add(nxt);
        }
        return [row];
    }

    const firstRow = [start];
    const inRow = new Set([start]);
    while (true) {
        const cur = firstRow[firstRow.length - 1];
        let nxt = -1;
        for (const nb of adj[cur]) {
            if (!inRow.has(nb) && deg[nb] <= minDeg + 1) {
                nxt = nb;
                break;
            }
        }
        if (nxt === -1) {
            break;
        }
        firstRow.push(nxt);
        inRow.add(nxt);
    }

    const cols = firstRow.length;
    const rows = Math.floor(n / cols);
    const grid = Array.from({ length: rows }, () => new Array(cols).fill(0));
    for (let c = 0; c < cols; c++) {
        grid[0][c] = firstRow[c];
    }
    const placed = new Set(firstRow);

    for (let r = 1; r < rows; r++) {
        for (let c = 0; c < cols; c++) {
            const above = grid[r - 1][c];
            for (const nb of adj[above]) {
                if (!placed.has(nb)) {
                    if (c === 0 || adj[nb].has(grid[r][c - 1])) {
                        grid[r][c] = nb;
                        placed.add(nb);
                        break;
                    }
                }
            }
        }
    }
    return grid;
};
