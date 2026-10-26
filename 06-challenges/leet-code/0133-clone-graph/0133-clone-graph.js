// https://leetcode.com/problems/clone-graph/

// Solution: DFS with Map — O(V+E) time, O(V) space
var cloneGraph = function(node) {
    if (!node) return null;

    const map = new Map();

    function dfs(n) {
        if (map.has(n)) return map.get(n);

        const clone = new Node(n.val);
        map.set(n, clone);

        for (const neighbor of n.neighbors) {
            clone.neighbors.push(dfs(neighbor));
        }

        return clone;
    }

    return dfs(node);
};
