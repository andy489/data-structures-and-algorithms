// https://leetcode.com/problems/number-of-restricted-paths-from-first-to-last-node/

var countRestrictedPaths = function(n, edges) {
    const MOD = 1_000_000_007n;
    const adj = Array.from({length: n + 1}, () => []);
    for (const [u, v, w] of edges) {
        adj[u].push([v, w]);
        adj[v].push([u, w]);
    }

    const dist = new Array(n + 1).fill(Infinity);
    dist[n] = 0;
    const pq = [[0, n]];

    while (pq.length) {
        pq.sort((a, b) => a[0] - b[0]);
        const [d, u] = pq.shift();
        if (d > dist[u]) continue;
        for (const [v, w] of adj[u]) {
            if (dist[u] + w < dist[v]) {
                dist[v] = dist[u] + w;
                pq.push([dist[v], v]);
            }
        }
    }

    const memo = new Array(n + 1).fill(-1n);
    memo[n] = 1n;

    function dp(u) {
        if (memo[u] !== -1n) return memo[u];
        memo[u] = 0n;
        for (const [v] of adj[u]) {
            if (dist[v] < dist[u]) {
                memo[u] = (memo[u] + dp(v)) % MOD;
            }
        }
        return memo[u];
    }

    return Number(dp(1));
};
