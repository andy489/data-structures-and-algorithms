// https://leetcode.com/problems/minimum-threshold-path-with-limited-heavy-edges/

/**
 * @param {number} n
 * @param {number[][]} edges
 * @param {number} source
 * @param {number} target
 * @param {number} k
 * @return {number}
 */
var minimumThreshold = function(n, edges, source, target, k) {
    if (source === target) {
        return 0;
    }
    const weightSet = new Set([0]);
    for (const e of edges) {
        weightSet.add(e[2]);
    }
    const weights = [...weightSet].sort((a, b) => a - b);
    const adj = Array.from({length: n}, () => []);
    for (const [u, v, w] of edges) {
        adj[u].push([v, w]);
        adj[v].push([u, w]);
    }

    function canReach(threshold) {
        const visited = Array.from({length: n}, () => new Array(k + 1).fill(false));
        const queue = [[source, 0]];
        visited[source][0] = true;
        let head = 0;
        while (head < queue.length) {
            const [node, heavy] = queue[head++];
            if (node === target) {
                return true;
            }
            for (const [nb, w] of adj[node]) {
                const newHeavy = heavy + (w > threshold ? 1 : 0);
                if (newHeavy <= k && !visited[nb][newHeavy]) {
                    visited[nb][newHeavy] = true;
                    queue.push([nb, newHeavy]);
                }
            }
        }
        return false;
    }

    let lo = 0, hi = weights.length - 1, ans = -1;
    while (lo <= hi) {
        const mid = (lo + hi) >> 1;
        if (canReach(weights[mid])) {
            ans = weights[mid];
            hi = mid - 1;
        } else {
            lo = mid + 1;
        }
    }
    return ans;
};
