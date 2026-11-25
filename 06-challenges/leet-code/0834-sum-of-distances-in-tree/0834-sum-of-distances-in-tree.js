// https://leetcode.com/problems/sum-of-distances-in-tree/

var sumOfDistancesInTree = function(n, edges) {
    const graph = Array.from({length: n}, () => []);
    for (const [u, v] of edges) { graph[u].push(v); graph[v].push(u); }
    const count = new Array(n).fill(1), ans = new Array(n).fill(0);

    function dfs1(node, parent) {
        for (const child of graph[node]) {
            if (child !== parent) {
                dfs1(child, node);
                count[node] += count[child];
                ans[node] += ans[child] + count[child];
            }
        }
    }

    function dfs2(node, parent) {
        for (const child of graph[node]) {
            if (child !== parent) {
                ans[child] = ans[node] - count[child] + (n - count[child]);
                dfs2(child, node);
            }
        }
    }

    dfs1(0, -1);
    dfs2(0, -1);
    return ans;
};
