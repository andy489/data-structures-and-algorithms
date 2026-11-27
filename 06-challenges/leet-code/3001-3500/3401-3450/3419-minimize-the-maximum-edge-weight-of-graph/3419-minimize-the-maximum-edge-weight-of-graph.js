// https://leetcode.com/problems/minimize-the-maximum-edge-weight-of-graph/

/**
 * @param {number} n
 * @param {number[][]} edges
 * @param {number} threshold
 * @return {number}
 */
var minMaxWeight = function(n, edges, threshold) {
    const canReach = (maxW) => {
        const byFrom = new Map();
        for (const [u, v, w] of edges) {
            if (w <= maxW) {
                if (!byFrom.has(u)) byFrom.set(u, []);
                byFrom.get(u).push([w, v]);
            }
        }
        const revAdj = Array.from({length: n}, () => []);
        for (const [u, outEdges] of byFrom) {
            outEdges.sort((a, b) => a[0] - b[0]);
            for (let i = 0; i < Math.min(outEdges.length, threshold); i++) {
                revAdj[outEdges[i][1]].push(u);
            }
        }
        const visited = new Array(n).fill(false);
        const queue = [0];
        visited[0] = true;
        let qi = 0;
        while (qi < queue.length) {
            const cur = queue[qi++];
            for (const nb of revAdj[cur]) {
                if (!visited[nb]) {
                    visited[nb] = true;
                    queue.push(nb);
                }
            }
        }
        return visited.every(v => v);
    };

    let lo = 1, hi = 1000000, ans = -1;
    while (lo <= hi) {
        const mid = lo + Math.floor((hi - lo) / 2);
        if (canReach(mid)) {
            ans = mid;
            hi = mid - 1;
        } else {
            lo = mid + 1;
        }
    }
    return ans;
};
