// https://leetcode.com/problems/minimum-cost-to-buy-apples-ii/

/**
 * @param {number} n
 * @param {number[]} prices
 * @param {number[][]} roads
 * @return {number[]}
 */
var minCostToBuyApples = function(n, prices, roads) {
    const emptyAdj = Array.from({length: n}, () => []);
    const loadedAdj = Array.from({length: n}, () => []);
    for (const [u, v, cost, tax] of roads) {
        emptyAdj[u].push([v, cost]);
        emptyAdj[v].push([u, cost]);
        loadedAdj[u].push([v, cost * tax]);
        loadedAdj[v].push([u, cost * tax]);
    }

    function dijkstra(adj, src) {
        const dist = new Array(n).fill(Infinity);
        dist[src] = 0;
        // Min-heap: [distance, node]
        const pq = [[0, src]];
        while (pq.length > 0) {
            pq.sort((a, b) => a[0] - b[0]);
            const [d, u] = pq.shift();
            if (d > dist[u]) {
                continue;
            }
            for (const [v, w] of adj[u]) {
                const nd = d + w;
                if (nd < dist[v]) {
                    dist[v] = nd;
                    pq.push([nd, v]);
                }
            }
        }
        return dist;
    }

    const distEmpty = Array.from({length: n}, (_, i) => dijkstra(emptyAdj, i));
    const distLoaded = Array.from({length: n}, (_, j) => dijkstra(loadedAdj, j));

    return Array.from({length: n}, (_, i) => {
        let best = prices[i];
        for (let j = 0; j < n; j++) {
            const total = prices[j] + distEmpty[i][j] + distLoaded[j][i];
            if (total < best) {
                best = total;
            }
        }
        return best;
    });
};
