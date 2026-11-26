// https://leetcode.com/problems/reorder-routes-to-make-all-paths-lead-to-the-city-zero/

var minReorder = function(n, connections) {
    const adj = Array.from({length:n},()=>[]);
    for (const [u,v] of connections) { adj[u].push([v,1]); adj[v].push([u,0]); }
    const visited = new Array(n).fill(false);
    visited[0] = true;
    const q = [0];
    let count = 0;
    while (q.length) {
        const u = q.shift();
        for (const [v,cost] of adj[u]) {
            if (!visited[v]) { visited[v]=true; count+=cost; q.push(v); }
        }
    }
    return count;
};
