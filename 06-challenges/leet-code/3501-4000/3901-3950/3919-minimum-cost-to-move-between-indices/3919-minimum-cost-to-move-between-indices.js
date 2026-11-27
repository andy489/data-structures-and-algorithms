// https://leetcode.com/problems/minimum-cost-to-move-between-indices/
/**
 * @param {number[]} nums
 * @param {number[][]} queries
 * @return {number[]}
 */
var minimumCost = function(nums, queries) {
    const n = nums.length;
    const closest = new Array(n);
    for (let x = 0; x < n; x++) {
        if (x === 0) {
            closest[x] = 1;
        } else if (x === n - 1) {
            closest[x] = n - 2;
        } else {
            const diffLeft = nums[x] - nums[x - 1];
            const diffRight = nums[x + 1] - nums[x];
            closest[x] = diffLeft <= diffRight ? x - 1 : x + 1;
        }
    }

    const adj = Array.from({length: n}, () => []);
    for (let x = 0; x < n; x++) {
        adj[x].push([closest[x], 1]);
        adj[closest[x]].push([x, 1]);
    }

    function dijkstra(src, dst) {
        if (src === dst) { return 0; }
        const dist = new Array(n).fill(Infinity);
        dist[src] = 0;
        const pq = [[0, src]];
        while (pq.length > 0) {
            pq.sort((a, b) => a[0] - b[0]);
            const [d, u] = pq.shift();
            if (d > dist[u]) { continue; }
            if (u === dst) { return d; }
            for (const [v, cost] of adj[u]) {
                const nd = d + cost;
                if (nd < dist[v]) {
                    dist[v] = nd;
                    pq.push([nd, v]);
                }
            }
            for (let v = 0; v < n; v++) {
                const nd = d + Math.abs(nums[u] - nums[v]);
                if (nd < dist[v]) {
                    dist[v] = nd;
                    pq.push([nd, v]);
                }
            }
        }
        return dist[dst];
    }

    return queries.map(([l, r]) => dijkstra(l, r));
};
