// https://leetcode.com/problems/is-graph-bipartite/

var isBipartite = function(graph) {
    const n = graph.length;
    const color = new Array(n).fill(-1);
    for (let start = 0; start < n; start++) {
        if (color[start] !== -1) continue;
        const queue = [start];
        color[start] = 0;
        while (queue.length) {
            const node = queue.shift();
            for (const neighbor of graph[node]) {
                if (color[neighbor] === -1) {
                    color[neighbor] = 1 - color[node];
                    queue.push(neighbor);
                } else if (color[neighbor] === color[node]) {
                    return false;
                }
            }
        }
    }
    return true;
};
