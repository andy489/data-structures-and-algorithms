// https://leetcode.com/problems/reachable-nodes-in-subdivided-graph/

var reachableNodes = function(edges, maxMoves, n) {
    const graph = Array.from({length: n}, () => []);
    for (const [u, v, cnt] of edges) {
        graph[u].push([v, cnt]);
        graph[v].push([u, cnt]);
    }
    const dist = new Array(n).fill(-1);
    const pq = new MaxPriorityQueue({priority: x => x[0]});
    pq.enqueue([maxMoves, 0]);
    while (pq.size()) {
        const [moves, u] = pq.dequeue().element;
        if (dist[u] !== -1) continue;
        dist[u] = moves;
        for (const [v, cnt] of graph[u]) {
            if (dist[v] === -1 && moves - cnt - 1 >= 0) {
                pq.enqueue([moves - cnt - 1, v]);
            }
        }
    }
    let ans = dist.filter(d => d >= 0).length;
    for (const [u, v, cnt] of edges) {
        const fu = dist[u] >= 0 ? Math.min(dist[u], cnt) : 0;
        const fv = dist[v] >= 0 ? Math.min(dist[v], cnt) : 0;
        ans += Math.min(fu + fv, cnt);
    }
    return ans;
};
