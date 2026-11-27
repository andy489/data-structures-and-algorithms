// https://leetcode.com/problems/incremental-even-weighted-cycle-queries/
/**
 * @param {number} n
 * @param {number[][]} edges
 * @return {number}
 */
var incrementalEvenWeightedCycleQueries = function(n, edges) {
    const parent = Array.from({length: n}, (_, i) => i);
    const rank = new Array(n).fill(0);
    const parity = new Array(n).fill(0);

    function find(x) {
        if (parent[x] !== x) {
            const [root, _] = find(parent[x]);
            parity[x] ^= parity[parent[x]];
            parent[x] = root;
        }
        return [parent[x], parity[x]];
    }

    let count = 0;
    for (const [u, v, w] of edges) {
        const [rootU, parU] = find(u);
        const [rootV, parV] = find(v);

        if (rootU !== rootV) {
            if (rank[rootU] < rank[rootV]) {
                parent[rootU] = rootV;
                parity[rootU] = parU ^ parV ^ w;
            } else if (rank[rootU] > rank[rootV]) {
                parent[rootV] = rootU;
                parity[rootV] = parU ^ parV ^ w;
            } else {
                parent[rootV] = rootU;
                parity[rootV] = parU ^ parV ^ w;
                rank[rootU]++;
            }
            count++;
        } else {
            if ((parU ^ parV) === (w % 2)) {
                count++;
            }
        }
    }
    return count;
};
