// https://leetcode.com/problems/maximum-points-after-collecting-coins-from-all-nodes/

var maximumPoints = function(edges, coins, k) {
    const n = coins.length;
    const adj = Array.from({length: n}, () => []);
    for (const [a, b] of edges) {
        adj[a].push(b);
        adj[b].push(a);
    }

    const memo = new Map();

    function dfs(node, parent, halvings) {
        if (halvings >= 14) return 0;
        const key = node * 15 + halvings;
        if (memo.has(key)) return memo.get(key);

        const v = coins[node] >> halvings;
        let opt1 = v - k;
        let opt2 = v >> 1;

        for (const child of adj[node]) {
            if (child === parent) continue;
            opt1 += dfs(child, node, halvings);
            opt2 += dfs(child, node, halvings + 1);
        }

        const best = Math.max(opt1, opt2);
        memo.set(key, best);
        return best;
    }

    return dfs(0, -1, 0);
};
