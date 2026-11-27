// https://leetcode.com/problems/sort-matrix-by-diagonals/
var sortMatrix = function(grid) {
    const n = grid.length;
    const diags = new Map();

    for (let i = 0; i < n; i++) {
        for (let j = 0; j < n; j++) {
            const key = i - j;
            if (!diags.has(key)) diags.set(key, []);
            diags.get(key).push(grid[i][j]);
        }
    }

    for (const [key, vals] of diags) {
        if (key >= 0) {
            vals.sort((a, b) => b - a);
        } else {
            vals.sort((a, b) => a - b);
        }
    }

    const idx = new Map();
    const res = Array.from({length: n}, () => new Array(n).fill(0));
    for (let i = 0; i < n; i++) {
        for (let j = 0; j < n; j++) {
            const key = i - j;
            const pos = idx.get(key) || 0;
            res[i][j] = diags.get(key)[pos];
            idx.set(key, pos + 1);
        }
    }

    return res;
};
