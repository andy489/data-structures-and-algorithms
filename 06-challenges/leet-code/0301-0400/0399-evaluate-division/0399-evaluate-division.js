// https://leetcode.com/problems/evaluate-division/

// Solution: Graph BFS — O((V+E)*Q) time, O(V+E) space
var calcEquation = function(equations, values, queries) {
    const graph = new Map();
    for (let i = 0; i < equations.length; i++) {
        const [a, b] = equations[i], v = values[i];
        if (!graph.has(a)) graph.set(a, new Map());
        if (!graph.has(b)) graph.set(b, new Map());
        graph.get(a).set(b, v);
        graph.get(b).set(a, 1 / v);
    }

    function bfs(src, dst) {
        if (!graph.has(src) || !graph.has(dst)) return -1;
        if (src === dst) return 1;
        const visited = new Map([[src, 1]]);
        const queue = [src];
        while (queue.length) {
            const node = queue.shift();
            for (const [next, w] of graph.get(node)) {
                if (!visited.has(next)) {
                    visited.set(next, visited.get(node) * w);
                    if (next === dst) return visited.get(next);
                    queue.push(next);
                }
            }
        }
        return -1;
    }

    return queries.map(([c, d]) => bfs(c, d));
};
