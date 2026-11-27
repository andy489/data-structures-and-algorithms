// https://leetcode.com/problems/minimum-height-trees/

var findMinHeightTrees = function(n, edges) {
    if (n === 1) { return [0]; }
    const adj = Array.from({length: n}, () => new Set());
    for (const [u, v] of edges) { adj[u].add(v); adj[v].add(u); }
    let leaves = [];
    for (let i = 0; i < n; i++) { if (adj[i].size === 1) leaves.push(i); }
    let remaining = n;
    while (remaining > 2) {
        remaining -= leaves.length;
        const newLeaves = [];
        for (const leaf of leaves) {
            const nb = adj[leaf].values().next().value;
            adj[nb].delete(leaf);
            if (adj[nb].size === 1) newLeaves.push(nb);
        }
        leaves = newLeaves;
    }
    return leaves;
};
