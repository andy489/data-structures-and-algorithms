// https://leetcode.com/problems/rank-transform-of-a-matrix/

var matrixRankTransform = function(matrix) {
    const m = matrix.length, n = matrix[0].length;
    const ans = Array.from({length: m}, () => new Array(n).fill(0));
    const rowRank = new Array(m).fill(0);
    const colRank = new Array(n).fill(0);

    const grouped = new Map();
    for (let i = 0; i < m; i++) {
        for (let j = 0; j < n; j++) {
            const v = matrix[i][j];
            if (!grouped.has(v)) grouped.set(v, []);
            grouped.get(v).push([i, j]);
        }
    }

    const sortedVals = [...grouped.keys()].sort((a, b) => a - b);

    function find(parent, x) {
        if (parent[x] !== x) parent[x] = find(parent, parent[x]);
        return parent[x];
    }

    for (const val of sortedVals) {
        const cells = grouped.get(val);
        const parent = Array.from({length: m + n}, (_, i) => i);

        for (const [i, j] of cells) {
            const pi = find(parent, i), pj = find(parent, m + j);
            if (pi !== pj) parent[pi] = pj;
        }

        const rootMax = new Map();
        for (const [i, j] of cells) {
            const root = find(parent, i);
            const cur = Math.max(rowRank[i], colRank[j]);
            rootMax.set(root, Math.max(rootMax.get(root) || 0, cur));
        }

        for (const [i, j] of cells) {
            const rank = rootMax.get(find(parent, i)) + 1;
            ans[i][j] = rank;
            rowRank[i] = Math.max(rowRank[i], rank);
            colRank[j] = Math.max(colRank[j], rank);
        }
    }
    return ans;
};
