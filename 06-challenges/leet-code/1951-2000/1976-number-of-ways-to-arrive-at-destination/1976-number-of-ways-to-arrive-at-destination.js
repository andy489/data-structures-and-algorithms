// https://leetcode.com/problems/number-of-ways-to-arrive-at-destination/

// Solution: Dijkstra + Count Paths — O((n + e) log n) time, O(n + e) space
var countPaths = function(n, roads) {
    const MOD = 1_000_000_007n;
    const graph = Array.from({length: n}, () => []);
    for (const [u, v, t] of roads) {
        graph[u].push([v, t]);
        graph[v].push([u, t]);
    }

    const dist = new Array(n).fill(Infinity);
    const ways = new Array(n).fill(0n);
    dist[0] = 0;
    ways[0] = 1n;

    // Min-heap: [dist, node]
    const pq = [[0, 0]];
    while (pq.length > 0) {
        pq.sort((a, b) => a[0] - b[0]);
        const [d, u] = pq.shift();
        if (d > dist[u]) continue;
        for (const [v, w] of graph[u]) {
            if (dist[u] + w < dist[v]) {
                dist[v] = dist[u] + w;
                ways[v] = ways[u];
                pq.push([dist[v], v]);
            } else if (dist[u] + w === dist[v]) {
                ways[v] = (ways[v] + ways[u]) % MOD;
            }
        }
    }
    return Number(ways[n - 1]);
};
