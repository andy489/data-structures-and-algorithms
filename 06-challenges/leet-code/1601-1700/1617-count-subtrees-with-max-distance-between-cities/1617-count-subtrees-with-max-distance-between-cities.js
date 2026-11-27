// https://leetcode.com/problems/count-subtrees-with-max-distance-between-cities/

var countSubgraphsForEachDiameter = function(n, edges) {
    const adj = Array.from({length: n + 1}, () => []);
    for (const [u, v] of edges) {
        adj[u].push(v);
        adj[v].push(u);
    }
    const dist = Array.from({length: n + 1}, () => new Array(n + 1).fill(0));
    for (let src = 1; src <= n; src++) {
        const visited = new Array(n + 1).fill(-1);
        visited[src] = 0;
        const q = [src];
        for (let qi = 0; qi < q.length; qi++) {
            const u = q[qi];
            for (const v of adj[u]) {
                if (visited[v] === -1) {
                    visited[v] = visited[u] + 1;
                    dist[src][v] = visited[v];
                    q.push(v);
                }
            }
        }
    }
    const ans = new Array(n - 1).fill(0);
    for (let mask = 1; mask < (1 << n); mask++) {
        const nodeCount = mask.toString(2).split('').filter(c => c === '1').length;
        if (nodeCount < 2) continue;
        let edgeCount = 0;
        for (const [u, v] of edges) {
            if ((mask >> (u - 1) & 1) && (mask >> (v - 1) & 1)) edgeCount++;
        }
        if (edgeCount !== nodeCount - 1) continue;
        let diameter = 0;
        for (let i = 0; i < n; i++) {
            if (!(mask >> i & 1)) continue;
            for (let j = i + 1; j < n; j++) {
                if (!(mask >> j & 1)) continue;
                diameter = Math.max(diameter, dist[i + 1][j + 1]);
            }
        }
        ans[diameter - 1]++;
    }
    return ans;
};
