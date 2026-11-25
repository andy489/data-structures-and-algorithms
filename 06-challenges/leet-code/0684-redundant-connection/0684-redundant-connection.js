// https://leetcode.com/problems/redundant-connection/

var findRedundantConnection = function(edges) {
    const n = edges.length;
    const parent = Array.from({length: n + 1}, (_, i) => i);
    const rank = new Array(n + 1).fill(0);

    function find(x) {
        while (parent[x] !== x) {
            parent[x] = parent[parent[x]];
            x = parent[x];
        }
        return x;
    }

    for (const [u, v] of edges) {
        const pu = find(u), pv = find(v);
        if (pu === pv) return [u, v];
        if (rank[pu] < rank[pv]) parent[pu] = pv;
        else if (rank[pu] > rank[pv]) parent[pv] = pu;
        else { parent[pv] = pu; rank[pu]++; }
    }
    return [];
};
