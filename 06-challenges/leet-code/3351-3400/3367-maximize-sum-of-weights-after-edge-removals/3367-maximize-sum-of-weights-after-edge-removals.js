// https://leetcode.com/problems/maximize-sum-of-weights-after-edge-removals/

var maximizeSumOfWeights = function(edges, k) {
    const n = edges.length + 1;
    const adj = Array.from({length: n}, () => []);
    for (const [u, v, w] of edges) {
        adj[u].push([v, w]);
        adj[v].push([u, w]);
    }

    // returns [f0, f1]: max sum without/with keeping edge to parent
    function dfs(v, parent) {
        let base = 0n;
        const gains = [];
        for (const [c, w] of adj[v]) {
            if (c === parent) {
                continue;
            }
            const [f0, f1] = dfs(c, v);
            base += f0;
            gains.push(BigInt(w) + f1 - f0);
        }
        gains.sort((a, b) => (a < b ? 1 : a > b ? -1 : 0));
        let f0 = base, f1 = base;
        for (let i = 0; i < gains.length; i++) {
            if (gains[i] <= 0n) {
                break;
            }
            if (i < k) {
                f0 += gains[i];
            }
            if (i < k - 1) {
                f1 += gains[i];
            }
        }
        return [f0, f1];
    }

    return Number(dfs(0, -1)[0]);
};
