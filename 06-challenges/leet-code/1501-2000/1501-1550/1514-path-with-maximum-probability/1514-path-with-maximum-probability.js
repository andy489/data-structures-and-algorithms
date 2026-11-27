// https://leetcode.com/problems/path-with-maximum-probability/

var maxProbability = function(n, edges, succProb, start, end) {
    const adj = Array.from({length: n}, () => []);
    for (let i = 0; i < edges.length; i++) {
        const [u, v] = edges[i], p = succProb[i];
        adj[u].push([v, p]);
        adj[v].push([u, p]);
    }
    const prob = new Array(n).fill(0);
    prob[start] = 1.0;
    // Simple BFS-style relaxation (Bellman-Ford style works for small graphs)
    // Use a max-heap approach via sorted queue simulation
    const heap = [[1.0, start]]; // [prob, node]
    // Max-heap using negation trick with a simple array + sort (n<=10^4, E<=2*10^4)
    while (heap.length) {
        heap.sort((a, b) => b[0] - a[0]);
        const [p, u] = heap.shift();
        if (p < prob[u]) continue;
        if (u === end) return p;
        for (const [v, ep] of adj[u]) {
            const np = p * ep;
            if (np > prob[v]) {
                prob[v] = np;
                heap.push([np, v]);
            }
        }
    }
    return 0.0;
};
