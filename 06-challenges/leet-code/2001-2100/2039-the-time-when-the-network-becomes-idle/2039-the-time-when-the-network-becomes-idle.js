// https://leetcode.com/problems/the-time-when-the-network-becomes-idle/

// Solution: BFS + Math — O(V+E) time, O(V+E) space
var networkBecomesIdle = function(edges, patience) {
    const n = patience.length;
    const adj = Array.from({length: n}, () => []);
    for (const [u, v] of edges) { adj[u].push(v); adj[v].push(u); }
    const dist = new Array(n).fill(-1);
    dist[0] = 0;
    const q = [0];
    for (let qi = 0; qi < q.length; qi++) {
        const u = q[qi];
        for (const v of adj[u]) { if (dist[v] === -1) { dist[v] = dist[u] + 1; q.push(v); } }
    }
    let ans = 0;
    for (let i = 1; i < n; i++) {
        const d = 2 * dist[i];
        const resends = Math.floor((d - 1) / patience[i]);
        const lastArrival = patience[i] * resends + d;
        ans = Math.max(ans, lastArrival + 1);
    }
    return ans;
};
