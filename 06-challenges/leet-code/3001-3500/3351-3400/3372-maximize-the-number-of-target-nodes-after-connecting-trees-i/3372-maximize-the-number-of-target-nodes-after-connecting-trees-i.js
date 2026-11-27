// https://leetcode.com/problems/maximize-the-number-of-target-nodes-after-connecting-trees-i/

var maxTargetNodes = function(edges1, edges2, k) {
    function buildAdj(edges, size) {
        const adj = Array.from({length: size}, () => []);
        for (const [u, v] of edges) {
            adj[u].push(v);
            adj[v].push(u);
        }
        return adj;
    }

    function bfsCount(adj, src, maxDist) {
        const dist = new Array(adj.length).fill(-1);
        dist[src] = 0;
        const queue = [src];
        let head = 0, count = 0;
        while (head < queue.length) {
            const v = queue[head++];
            if (dist[v] <= maxDist) {
                count++;
                for (const nb of adj[v]) {
                    if (dist[nb] === -1) {
                        dist[nb] = dist[v] + 1;
                        if (dist[nb] <= maxDist) {
                            queue.push(nb);
                        }
                    }
                }
            }
        }
        return count;
    }

    const n = edges1.length + 1;
    const m = edges2.length + 1;
    const adj1 = buildAdj(edges1, n);
    const adj2 = buildAdj(edges2, m);

    let best2 = 0;
    if (k > 0) {
        for (let j = 0; j < m; j++) {
            best2 = Math.max(best2, bfsCount(adj2, j, k - 1));
        }
    }

    return Array.from({length: n}, (_, i) => bfsCount(adj1, i, k) + best2);
};
