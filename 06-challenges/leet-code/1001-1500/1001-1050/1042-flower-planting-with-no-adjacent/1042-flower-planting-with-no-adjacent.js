// https://leetcode.com/problems/flower-planting-with-no-adjacent/

var gardenNoAdj = function(n, paths) {
    const adj = Array.from({length: n+1}, () => []);
    for (const [u, v] of paths) { adj[u].push(v); adj[v].push(u); }
    const ans = new Array(n+1).fill(0);
    for (let i = 1; i <= n; i++) {
        const used = new Set(adj[i].map(nb => ans[nb]));
        for (let c = 1; c <= 4; c++) {
            if (!used.has(c)) { ans[i] = c; break; }
        }
    }
    return ans.slice(1);
};
