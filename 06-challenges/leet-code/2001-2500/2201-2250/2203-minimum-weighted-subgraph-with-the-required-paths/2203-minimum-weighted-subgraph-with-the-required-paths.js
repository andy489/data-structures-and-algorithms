// https://leetcode.com/problems/minimum-weighted-subgraph-with-the-required-paths/
var minimumWeight = function(n, edges, src1, src2, dest) {
    const INF = BigInt(Number.MAX_SAFE_INTEGER);

    const graph = Array.from({ length: n }, () => []);
    const revGraph = Array.from({ length: n }, () => []);
    for (const [u, v, w] of edges) {
        graph[u].push([v, w]);
        revGraph[v].push([u, w]);
    }

    function dijkstra(g, src) {
        const dist = new Array(n).fill(INF);
        dist[src] = 0n;
        // Min-heap using sorted array (simple for JS, O((V+E)logV) with priority queue)
        const pq = [[0n, src]];
        while (pq.length > 0) {
            pq.sort((a, b) => (a[0] < b[0] ? -1 : a[0] > b[0] ? 1 : 0));
            const [d, u] = pq.shift();
            if (d > dist[u]) {
                continue;
            }
            for (const [v, w] of g[u]) {
                const nd = dist[u] + BigInt(w);
                if (nd < dist[v]) {
                    dist[v] = nd;
                    pq.push([nd, v]);
                }
            }
        }
        return dist;
    }

    const dist1 = dijkstra(graph, src1);
    const dist2 = dijkstra(graph, src2);
    const distDest = dijkstra(revGraph, dest);

    let ans = INF;
    for (let v = 0; v < n; v++) {
        if (dist1[v] < INF && dist2[v] < INF && distDest[v] < INF) {
            const total = dist1[v] + dist2[v] + distDest[v];
            if (total < ans) {
                ans = total;
            }
        }
    }
    return ans === INF ? -1 : Number(ans);
};
