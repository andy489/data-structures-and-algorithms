// https://leetcode.com/problems/redundant-connection-ii/

var findRedundantDirectedConnection = function(edges) {
    const n = edges.length;
    const parentOf = new Array(n + 1).fill(0);
    let cand1 = null, cand2 = null;
    for (const [u, v] of edges) {
        if (parentOf[v]) {
            cand1 = [parentOf[v], v];
            cand2 = [u, v];
            break;
        }
        parentOf[v] = u;
    }

    const parent = Array.from({length: n + 1}, (_, i) => i);
    function find(x) {
        while (parent[x] !== x) { parent[x] = parent[parent[x]]; x = parent[x]; }
        return x;
    }

    for (const [u, v] of edges) {
        if (cand2 && u === cand2[0] && v === cand2[1]) continue;
        const pu = find(u), pv = find(v);
        if (pu === pv) return cand1 || [u, v];
        parent[pv] = pu;
    }
    return cand2;
};
