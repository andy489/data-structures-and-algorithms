// https://leetcode.com/problems/parallel-courses-iii/

// Solution: Topological Sort DP — O(V+E) time, O(V+E) space
var minimumTime = function(n, relations, time) {
    const nxt = Array.from({length: n+1}, () => []);
    const inDeg = new Array(n+1).fill(0);
    const dp = new Array(n+1).fill(0);
    for (const [u, v] of relations) { nxt[u].push(v); inDeg[v]++; }
    const q = [];
    for (let i = 1; i <= n; i++) { if (inDeg[i] === 0) { q.push(i); dp[i] = time[i-1]; } }
    for (let qi = 0; qi < q.length; qi++) {
        const u = q[qi];
        for (const v of nxt[u]) {
            dp[v] = Math.max(dp[v], dp[u] + time[v-1]);
            if (--inDeg[v] === 0) q.push(v);
        }
    }
    return Math.max(...dp);
};
