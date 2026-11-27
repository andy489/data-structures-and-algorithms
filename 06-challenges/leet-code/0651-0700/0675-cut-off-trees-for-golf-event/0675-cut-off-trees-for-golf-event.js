// https://leetcode.com/problems/cut-off-trees-for-golf-event/

var cutOffTree = function(forest) {
    const m = forest.length, n = forest[0].length;
    const trees = [];
    for (let i = 0; i < m; i++) {
        for (let j = 0; j < n; j++) {
            if (forest[i][j] > 1) trees.push([forest[i][j], i, j]);
        }
    }
    trees.sort((a, b) => a[0] - b[0]);

    function bfs(sr, sc, tr, tc) {
        if (sr === tr && sc === tc) return 0;
        const visited = Array.from({length: m}, () => new Array(n).fill(false));
        visited[sr][sc] = true;
        const queue = [[sr, sc, 0]];
        const dirs = [[0,1],[0,-1],[1,0],[-1,0]];
        for (let qi = 0; qi < queue.length; qi++) {
            const [r, c, dist] = queue[qi];
            for (const [dr, dc] of dirs) {
                const nr = r + dr, nc = c + dc;
                if (nr >= 0 && nr < m && nc >= 0 && nc < n && !visited[nr][nc] && forest[nr][nc] !== 0) {
                    if (nr === tr && nc === tc) return dist + 1;
                    visited[nr][nc] = true;
                    queue.push([nr, nc, dist + 1]);
                }
            }
        }
        return -1;
    }

    let sr = 0, sc = 0, total = 0;
    for (const [, tr, tc] of trees) {
        const steps = bfs(sr, sc, tr, tc);
        if (steps === -1) return -1;
        total += steps;
        sr = tr; sc = tc;
    }
    return total;
};
