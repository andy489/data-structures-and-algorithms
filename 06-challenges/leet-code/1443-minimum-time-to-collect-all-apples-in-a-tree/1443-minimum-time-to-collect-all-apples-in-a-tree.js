// https://leetcode.com/problems/minimum-time-to-collect-all-apples-in-a-tree/

var minTime = function(n, edges, hasApple) {
    const adj = Array.from({length: n}, () => []);
    for (const [u, v] of edges) { adj[u].push(v); adj[v].push(u); }
    function dfs(u, parent) {
        let total = 0;
        for (const v of adj[u]) {
            if (v === parent) continue;
            const cost = dfs(v, u);
            if (cost > 0 || hasApple[v]) total += cost + 2;
        }
        return total;
    }
    return dfs(0, -1);
};
