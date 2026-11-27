// https://leetcode.com/problems/critical-connections-in-a-network/

// Solution: Tarjan's Bridge-Finding Algorithm — O(V+E) time, O(V+E) space
var criticalConnections = function(n, connections) {
    const graph = Array.from({length: n}, () => []);
    for (const [u, v] of connections) {
        graph[u].push(v);
        graph[v].push(u);
    }

    const disc = new Array(n).fill(-1);
    const low = new Array(n).fill(-1);
    const bridges = [];
    let timer = 0;

    function dfs(u, parent) {
        disc[u] = low[u] = timer++;
        for (const v of graph[u]) {
            if (v === parent) {
                continue;
            }
            if (disc[v] === -1) {
                dfs(v, u);
                low[u] = Math.min(low[u], low[v]);
                if (low[v] > disc[u]) {
                    bridges.push([u, v]);
                }
            } else {
                low[u] = Math.min(low[u], disc[v]);
            }
        }
    }

    for (let i = 0; i < n; i++) {
        if (disc[i] === -1) {
            dfs(i, -1);
        }
    }
    return bridges;
};
