// https://leetcode.com/problems/count-connected-subgraphs-with-even-node-sum/
/**
 * @param {number[]} nums
 * @param {number[][]} edges
 * @return {number}
 */
var countSubgraphs = function(nums, edges) {
    const n = nums.length;
    const adj = new Array(n).fill(0);
    for (const [u, v] of edges) {
        adj[u] |= (1 << v);
        adj[v] |= (1 << u);
    }

    function isConnected(mask) {
        const start = Math.clz32(mask) ^ 31;
        let visited = 1 << start;
        let queue = visited;
        while (queue !== 0) {
            const node = Math.clz32(queue) ^ 31;
            queue &= ~(1 << node);
            const neighbors = adj[node] & mask & ~visited;
            visited |= neighbors;
            queue |= neighbors;
        }
        return visited === mask;
    }

    let count = 0;
    for (let mask = 1; mask < (1 << n); mask++) {
        let sum = 0;
        for (let i = 0; i < n; i++) {
            if (mask & (1 << i)) { sum += nums[i]; }
        }
        if (sum % 2 === 0 && isConnected(mask)) {
            count++;
        }
    }
    return count;
};
