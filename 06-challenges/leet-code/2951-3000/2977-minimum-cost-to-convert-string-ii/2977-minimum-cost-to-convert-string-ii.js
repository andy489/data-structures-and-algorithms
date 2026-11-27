// https://leetcode.com/problems/minimum-cost-to-convert-string-ii/
var minimumCost = function(source, target, original, changed, cost) {
    const INF = Infinity;
    const idMap = new Map();
    const getId = (s) => {
        if (!idMap.has(s)) idMap.set(s, idMap.size);
        return idMap.get(s);
    };
    for (const s of [...original, ...changed]) getId(s);
    const K = idMap.size;
    const dist = Array.from({length: K}, (_, i) => {
        const row = new Array(K).fill(INF);
        row[i] = 0;
        return row;
    });
    for (let i = 0; i < original.length; i++) {
        const f = idMap.get(original[i]), t = idMap.get(changed[i]);
        dist[f][t] = Math.min(dist[f][t], cost[i]);
    }
    for (let k = 0; k < K; k++) {
        for (let i = 0; i < K; i++) {
            for (let j = 0; j < K; j++) {
                if (dist[i][k] + dist[k][j] < dist[i][j]) {
                    dist[i][j] = dist[i][k] + dist[k][j];
                }
            }
        }
    }
    const n = source.length;
    const dp = new Array(n + 1).fill(INF);
    dp[0] = 0;
    for (let i = 0; i < n; i++) {
        if (dp[i] === INF) continue;
        if (source[i] === target[i]) dp[i + 1] = Math.min(dp[i + 1], dp[i]);
        for (const [sub, fid] of idMap) {
            const len = sub.length;
            if (i + len > n) continue;
            if (source.substring(i, i + len) !== sub) continue;
            const tgtSub = target.substring(i, i + len);
            if (!idMap.has(tgtSub)) continue;
            const tid = idMap.get(tgtSub);
            if (dist[fid][tid] < INF) {
                dp[i + len] = Math.min(dp[i + len], dp[i] + dist[fid][tid]);
            }
        }
    }
    return dp[n] === INF ? -1 : dp[n];
};
