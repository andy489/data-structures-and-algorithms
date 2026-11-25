// https://leetcode.com/problems/find-eventual-safe-states/

var eventualSafeNodes = function(graph) {
    const n = graph.length;
    const color = new Array(n).fill(0);

    function dfs(node) {
        if (color[node] > 0) {
            return color[node] === 2;
        }
        color[node] = 1;
        for (const neighbor of graph[node]) {
            if (!dfs(neighbor)) {
                return false;
            }
        }
        color[node] = 2;
        return true;
    }

    const result = [];
    for (let i = 0; i < n; i++) {
        if (dfs(i)) {
            result.push(i);
        }
    }
    return result;
};
