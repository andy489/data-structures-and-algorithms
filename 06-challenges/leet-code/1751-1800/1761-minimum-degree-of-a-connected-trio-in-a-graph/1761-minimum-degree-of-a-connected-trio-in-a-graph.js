// https://leetcode.com/problems/minimum-degree-of-a-connected-trio-in-a-graph/

var minTrioDegree = function(n, edges) {
    const adj = Array.from({length: n + 1}, () => new Array(n + 1).fill(false));
    const deg = new Array(n + 1).fill(0);
    for (const [u, v] of edges) {
        adj[u][v] = adj[v][u] = true;
        deg[u]++;
        deg[v]++;
    }
    let ans = Infinity;
    for (let i = 1; i <= n; i++) {
        for (let j = i + 1; j <= n; j++) {
            if (!adj[i][j]) continue;
            for (let k = j + 1; k <= n; k++) {
                if (adj[i][k] && adj[j][k]) {
                    ans = Math.min(ans, deg[i] + deg[j] + deg[k] - 6);
                }
            }
        }
    }
    return ans === Infinity ? -1 : ans;
};
