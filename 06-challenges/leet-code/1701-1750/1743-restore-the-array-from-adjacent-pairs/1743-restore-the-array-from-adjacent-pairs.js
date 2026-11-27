// https://leetcode.com/problems/restore-the-array-from-adjacent-pairs/

var restoreArray = function(adjacentPairs) {
    const adj = new Map();
    for (const [u, v] of adjacentPairs) {
        if (!adj.has(u)) adj.set(u, []);
        if (!adj.has(v)) adj.set(v, []);
        adj.get(u).push(v);
        adj.get(v).push(u);
    }
    const n = adjacentPairs.length + 1;
    const result = new Array(n);
    for (const [key, neighbors] of adj) {
        if (neighbors.length === 1) {
            result[0] = key;
            break;
        }
    }
    result[1] = adj.get(result[0])[0];
    for (let i = 2; i < n; i++) {
        const prev = result[i - 2], cur = result[i - 1];
        const neighbors = adj.get(cur);
        result[i] = neighbors[0] === prev ? neighbors[1] : neighbors[0];
    }
    return result;
};
