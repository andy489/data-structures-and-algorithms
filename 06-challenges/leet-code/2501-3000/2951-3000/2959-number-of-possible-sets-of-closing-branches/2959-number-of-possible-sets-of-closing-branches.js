// https://leetcode.com/problems/number-of-possible-sets-of-closing-branches/
var numberOfSets = function(n, maxDistance, roads) {
    const INF = Infinity;
    let ans = 0;
    for (let mask = 0; mask < (1 << n); mask++) {
        const dist = Array.from({ length: n }, (_, i) =>
            Array.from({ length: n }, (_, j) => i === j ? 0 : INF)
        );
        for (const [u, v, w] of roads) {
            if (!(mask >> u & 1) && !(mask >> v & 1)) {
                if (w < dist[u][v]) {
                    dist[u][v] = w;
                }
                if (w < dist[v][u]) {
                    dist[v][u] = w;
                }
            }
        }
        for (let k = 0; k < n; k++) {
            if (mask >> k & 1) {
                continue;
            }
            for (let i = 0; i < n; i++) {
                if (mask >> i & 1) {
                    continue;
                }
                for (let j = 0; j < n; j++) {
                    if (mask >> j & 1) {
                        continue;
                    }
                    if (dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }
        let valid = true;
        outer:
        for (let i = 0; i < n; i++) {
            if (mask >> i & 1) {
                continue;
            }
            for (let j = i + 1; j < n; j++) {
                if (mask >> j & 1) {
                    continue;
                }
                if (dist[i][j] > maxDistance) {
                    valid = false;
                    break outer;
                }
            }
        }
        if (valid) {
            ans++;
        }
    }
    return ans;
};
