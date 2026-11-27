// https://leetcode.com/problems/number-of-nodes-in-the-sub-tree-with-the-same-label/

var countSubTrees = function(n, edges, labels) {
    const adj = Array.from({length: n}, () => []);
    for (const [u, v] of edges) {
        adj[u].push(v);
        adj[v].push(u);
    }
    const ans = new Array(n).fill(0);

    function dfs(node, parent) {
        const freq = new Array(26).fill(0);
        freq[labels.charCodeAt(node) - 97]++;
        for (const child of adj[node]) {
            if (child === parent) continue;
            const childFreq = dfs(child, node);
            for (let i = 0; i < 26; i++) freq[i] += childFreq[i];
        }
        ans[node] = freq[labels.charCodeAt(node) - 97];
        return freq;
    }

    dfs(0, -1);
    return ans;
};
