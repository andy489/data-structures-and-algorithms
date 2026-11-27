// https://leetcode.com/problems/detect-cycles-in-2d-grid/

var containsCycle = function(grid) {
    const m = grid.length, n = grid[0].length;
    const parent = Array.from({length: m * n}, (_, i) => i);
    const rank = new Array(m * n).fill(0);

    const find = (x) => {
        while (parent[x] !== x) {
            parent[x] = parent[parent[x]];
            x = parent[x];
        }
        return x;
    };

    const union = (a, b) => {
        const ra = find(a), rb = find(b);
        if (ra === rb) {
            return false;
        }
        if (rank[ra] < rank[rb]) {
            parent[ra] = rb;
        } else if (rank[ra] > rank[rb]) {
            parent[rb] = ra;
        } else {
            parent[rb] = ra;
            rank[ra]++;
        }
        return true;
    };

    for (let i = 0; i < m; i++) {
        for (let j = 0; j < n; j++) {
            for (const [di, dj] of [[0, 1], [1, 0]]) {
                const ni = i + di, nj = j + dj;
                if (ni < m && nj < n && grid[ni][nj] === grid[i][j]) {
                    if (!union(i * n + j, ni * n + nj)) {
                        return true;
                    }
                }
            }
        }
    }
    return false;
};
