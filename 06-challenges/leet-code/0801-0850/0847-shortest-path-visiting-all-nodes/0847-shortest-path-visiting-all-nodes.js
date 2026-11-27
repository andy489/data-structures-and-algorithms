// https://leetcode.com/problems/shortest-path-visiting-all-nodes/

var shortestPathLength = function(graph) {
    const n = graph.length;
    const full = (1 << n) - 1;
    const queue = [];
    const visited = new Set();
    for (let i = 0; i < n; i++) {
        const mask = 1 << i;
        queue.push([i, mask, 0]);
        visited.add(`${i},${mask}`);
    }
    let head = 0;
    while (head < queue.length) {
        const [node, mask, dist] = queue[head++];
        if (mask === full) return dist;
        for (const next of graph[node]) {
            const nextMask = mask | (1 << next);
            const key = `${next},${nextMask}`;
            if (!visited.has(key)) {
                visited.add(key);
                queue.push([next, nextMask, dist + 1]);
            }
        }
    }
    return -1;
};
