// https://leetcode.com/problems/longest-special-path-ii/

var longestSpecialPath = function(edges, nums) {
    const n = nums.length;
    const adj = Array.from({length: n}, () => []);
    for (const [u, v, w] of edges) {
        adj[u].push([v, w]);
        adj[v].push([u, w]);
    }
    const maxVal = Math.max(...nums);
    const last1 = new Int32Array(maxVal + 1).fill(-1);
    const last2 = new Int32Array(maxVal + 1).fill(-1);
    const prefix = new Array(n + 2).fill(0);
    let bestLen = 0, bestNodes = 1;

    const dfs = (node, parent, depth, start) => {
        const v = nums[node];
        const prev1 = last1[v], prev2 = last2[v];
        last2[v] = last1[v];
        last1[v] = depth;
        let newStart = start;
        if (prev2 !== -1) newStart = Math.max(newStart, prev2 + 1);
        const pathLen = prefix[depth + 1] - prefix[newStart];
        const nodeCount = depth - newStart + 1;
        if (pathLen > bestLen || (pathLen === bestLen && nodeCount < bestNodes)) {
            bestLen = pathLen;
            bestNodes = nodeCount;
        }
        for (const [nb, w] of adj[node]) {
            if (nb !== parent) {
                prefix[depth + 2] = prefix[depth + 1] + w;
                dfs(nb, node, depth + 1, newStart);
            }
        }
        last1[v] = prev1;
        last2[v] = prev2;
    };

    dfs(0, -1, 0, 0);
    return [bestLen, bestNodes];
};
