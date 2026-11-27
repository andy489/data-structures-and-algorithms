// https://leetcode.com/problems/second-minimum-time-to-reach-destination/

// Solution: Multi-source BFS — O(V+E) time, O(V+E) space
var secondMinimum = function(n, edges, time, change) {
    const adj = Array.from({length: n+1}, () => []);
    for (const [u, v] of edges) { adj[u].push(v); adj[v].push(u); }
    const INF = Infinity;
    const dist1 = new Array(n+1).fill(INF), dist2 = new Array(n+1).fill(INF);
    dist1[1] = 0;
    const q = [[1, 0]];
    for (let qi = 0; qi < q.length; qi++) {
        const [u, d] = q[qi];
        for (const v of adj[u]) {
            if (d + 1 < dist1[v]) { dist2[v] = dist1[v]; dist1[v] = d + 1; q.push([v, dist1[v]]); }
            else if (d + 1 > dist1[v] && d + 1 < dist2[v]) { dist2[v] = d + 1; q.push([v, dist2[v]]); }
        }
    }
    const steps = dist2[n] < INF ? dist2[n] : dist1[n] + 1;
    let t = 0;
    for (let i = 0; i < steps; i++) {
        if (Math.floor(t / change) % 2 === 1) t = (Math.floor(t / change) + 1) * change;
        t += time;
    }
    return t;
};
