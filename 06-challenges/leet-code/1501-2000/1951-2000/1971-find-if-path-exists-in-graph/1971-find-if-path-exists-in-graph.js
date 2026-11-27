// https://leetcode.com/problems/find-if-path-exists-in-graph/

// Solution: Union-Find — O((n + e) * alpha(n)) time, O(n) space
var validPath = function(n, edges, source, destination) {
    const parent = Array.from({length: n}, (_, i) => i);

    const find = (x) => {
        if (parent[x] !== x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    };

    const union = (x, y) => {
        parent[find(x)] = find(y);
    };

    for (const [u, v] of edges) {
        union(u, v);
    }
    return find(source) === find(destination);
};
