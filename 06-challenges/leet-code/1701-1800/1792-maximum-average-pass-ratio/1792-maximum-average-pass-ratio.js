// https://leetcode.com/problems/maximum-average-pass-ratio/

var maxAverageRatio = function(classes, extraStudents) {
    const gain = (p, t) => (p + 1) / (t + 1) - p / t;

    // Simple max heap using array (for LeetCode constraints)
    const heap = classes.map(([p, t]) => [gain(p, t), p, t]);
    heap.sort((a, b) => b[0] - a[0]);

    for (let i = 0; i < extraStudents; i++) {
        const [, p, t] = heap.shift();
        const np = p + 1, nt = t + 1;
        const entry = [gain(np, nt), np, nt];
        // Insert in sorted position
        let lo = 0, hi = heap.length;
        while (lo < hi) {
            const mid = (lo + hi) >> 1;
            if (heap[mid][0] >= entry[0]) lo = mid + 1;
            else hi = mid;
        }
        heap.splice(lo, 0, entry);
    }

    const total = heap.reduce((acc, [, p, t]) => acc + p / t, 0);
    return total / classes.length;
};
