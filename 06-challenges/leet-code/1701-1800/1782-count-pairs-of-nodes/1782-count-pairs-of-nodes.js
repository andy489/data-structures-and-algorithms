// https://leetcode.com/problems/count-pairs-of-nodes/

var countPairs = function(n, edges, queries) {
    const deg = new Array(n + 1).fill(0);
    const shared = new Map();

    for (const [u, v] of edges) {
        deg[u]++;
        deg[v]++;
        const key = Math.min(u, v) * 20001 + Math.max(u, v);
        shared.set(key, (shared.get(key) || 0) + 1);
    }

    const sorted = deg.slice(1).sort((a, b) => a - b);
    const ans = [];

    for (const threshold of queries) {
        let count = 0;
        let lo = 0, hi = n - 1;
        while (lo < hi) {
            if (sorted[lo] + sorted[hi] > threshold) {
                count += hi - lo;
                hi--;
            } else {
                lo++;
            }
        }
        for (const [key, cnt] of shared) {
            const u = Math.floor(key / 20001);
            const v = key % 20001;
            if (deg[u] + deg[v] > threshold && deg[u] + deg[v] - cnt <= threshold) {
                count--;
            }
        }
        ans.push(count);
    }
    return ans;
};
