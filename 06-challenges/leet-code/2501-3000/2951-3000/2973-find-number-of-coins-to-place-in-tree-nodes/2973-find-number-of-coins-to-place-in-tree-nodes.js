// https://leetcode.com/problems/find-number-of-coins-to-place-in-tree-nodes/
var placedCoins = function(edges, cost) {
    const n = cost.length;
    const adj = Array.from({length: n}, () => []);
    for (const [a, b] of edges) {
        adj[a].push(b);
        adj[b].push(a);
    }
    const coins = new Array(n).fill(0n);

    const dfs = (node, parent) => {
        let subtree = [cost[node]];
        for (const child of adj[node]) {
            if (child !== parent) {
                subtree = subtree.concat(dfs(child, node));
            }
        }
        subtree.sort((a, b) => a - b);
        const size = subtree.length;
        if (size < 3) {
            coins[node] = 1n;
        } else {
            const opt1 = BigInt(subtree[size - 1]) * BigInt(subtree[size - 2]) * BigInt(subtree[size - 3]);
            const opt2 = BigInt(subtree[0]) * BigInt(subtree[1]) * BigInt(subtree[size - 1]);
            const best = opt1 > opt2 ? opt1 : opt2;
            coins[node] = best > 0n ? best : 0n;
        }
        if (size > 5) {
            return [...subtree.slice(0, 2), ...subtree.slice(size - 3)];
        }
        return subtree;
    };

    dfs(0, -1);
    return coins;
};
