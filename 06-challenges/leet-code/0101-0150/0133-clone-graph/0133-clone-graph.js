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

// Solution 2: BFS with Map — O(V+E) time, O(V) space
var cloneGraph2 = function(node) {
    if (!node) {
        return null;
    }

    // maps each original node to its clone
    const cloned = new Map();

    const queue = [node];

    cloned.set(node, new Node(node.val));

    while (queue.length > 0) {
        const current = queue.shift();

        for (const neighbor of current.neighbors) {
            // clone the neighbor if not yet seen
            if (!cloned.has(neighbor)) {
                cloned.set(neighbor, new Node(neighbor.val));
                queue.push(neighbor);
            }

            // connect current clone to neighbor's clone
            cloned.get(current).neighbors.push(cloned.get(neighbor));
        }
    }

    return cloned.get(node);
};
