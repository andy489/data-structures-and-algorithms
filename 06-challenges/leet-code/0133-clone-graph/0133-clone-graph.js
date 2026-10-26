// https://leetcode.com/problems/clone-graph/

// Solution: DFS with Map — O(V+E) time, O(V) space
var cloneGraph = function(node) {
    if (!node) {
        return null;
    }

    const cloned = new Map();

    function dfs(n) {
        if (cloned.has(n)) {
            return cloned.get(n);
        }

        const clone = new Node(n.val);
        cloned.set(n, clone);

        for (const neighbor of n.neighbors) {
            clone.neighbors.push(dfs(neighbor));
        }

        return clone;
    }

    return dfs(node);
};
