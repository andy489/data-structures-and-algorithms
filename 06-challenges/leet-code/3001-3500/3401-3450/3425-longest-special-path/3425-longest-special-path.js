// https://leetcode.com/problems/longest-special-path/

/**
 * @param {number[][]} edges
 * @param {number[]} nums
 * @return {number[]}
 */
var longestSpecialPath = function(edges, nums) {
    const n = nums.length;
    const adj = Array.from({length: n}, () => []);
    for (const [u, v, w] of edges) {
        adj[u].push([v, w]);
        adj[v].push([u, w]);
    }
    let bestLen = 0, bestNodes = 1;
    const prefixDist = new Array(n + 1).fill(0);
    const lastDepth = new Map();

    const dfs = (node, parent, depth, startDepth) => {
        const val = nums[node];
        const prevDepth = lastDepth.has(val) ? lastDepth.get(val) : -1;
        const newStart = Math.max(startDepth, prevDepth + 1);
        const pathLength = prefixDist[depth] - prefixDist[newStart];
        const nodeCount = depth - newStart + 1;
        if (pathLength > bestLen || (pathLength === bestLen && nodeCount < bestNodes)) {
            bestLen = pathLength;
            bestNodes = nodeCount;
        }
        lastDepth.set(val, depth);
        for (const [nb, w] of adj[node]) {
            if (nb !== parent) {
                prefixDist[depth + 1] = prefixDist[depth] + w;
                dfs(nb, node, depth + 1, newStart);
            }
        }
        if (prevDepth === -1) lastDepth.delete(val);
        else lastDepth.set(val, prevDepth);
    };

    dfs(0, -1, 0, 0);
    return [bestLen, bestNodes];
};
