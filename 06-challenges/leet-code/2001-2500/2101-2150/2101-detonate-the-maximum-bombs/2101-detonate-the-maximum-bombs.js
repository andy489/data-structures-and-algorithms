// https://leetcode.com/problems/detonate-the-maximum-bombs/

// Solution: BFS on Directed Graph — O(n^3) time, O(n^2) space
var maximumDetonation = function(bombs) {
    const n = bombs.length;
    const graph = Array.from({length: n}, () => []);

    for (let i = 0; i < n; i++) {
        const [xi, yi, ri] = bombs[i];
        for (let j = 0; j < n; j++) {
            if (i === j) continue;
            const dx = bombs[j][0] - xi;
            const dy = bombs[j][1] - yi;
            if (dx * dx + dy * dy <= ri * ri) {
                graph[i].push(j);
            }
        }
    }

    let maxDetonated = 0;

    for (let start = 0; start < n; start++) {
        const visited = new Set([start]);
        const queue = [start];
        for (let qi = 0; qi < queue.length; qi++) {
            for (const next of graph[queue[qi]]) {
                if (!visited.has(next)) {
                    visited.add(next);
                    queue.push(next);
                }
            }
        }
        maxDetonated = Math.max(maxDetonated, visited.size);
    }

    return maxDetonated;
};
