// https://leetcode.com/problems/maximum-path-quality-of-a-graph/

// Solution: DFS with Backtracking — O(n * maxTime) time, O(n) space
var maximalPathQuality = function(values, edges, maxTime) {
    const n = values.length;
    const adj = Array.from({length: n}, () => []);
    for (const [u, v, w] of edges) { adj[u].push([v, w]); adj[v].push([u, w]); }
    let res = 0;
    const cnt = new Array(n).fill(0);
    cnt[0] = 1;
    const dfs = (node, time, quality) => {
        if (node === 0) res = Math.max(res, quality);
        for (const [v, w] of adj[node]) {
            if (time + w <= maxTime) {
                cnt[v]++;
                dfs(v, time + w, quality + (cnt[v] === 1 ? values[v] : 0));
                cnt[v]--;
            }
        }
    };
    dfs(0, 0, values[0]);
    return res;
};
