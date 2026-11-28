// https://leetcode.com/problems/maximum-score-after-applying-operations-on-a-tree/

var maximumScoreAfterOperations = function(edges, values) {
    const n = values.length;
    const adj = Array.from({ length: n }, () => []);
    for (const [u, v] of edges) {
        adj[u].push(v);
        adj[v].push(u);
    }

    function dfs(node, parent) {
        let childKeep = 0;
        let isLeaf = true;
        for (const child of adj[node]) {
            if (child === parent) continue;
            isLeaf = false;
            childKeep += dfs(child, node);
        }
        if (isLeaf) return values[node];
        return Math.min(values[node], childKeep);
    }

    const total = values.reduce((s, v) => s + v, 0);
    return total - dfs(0, -1);
};
