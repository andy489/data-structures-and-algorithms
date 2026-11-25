// https://leetcode.com/problems/minimum-cost-to-hire-k-workers/

var mincostToHireWorkers = function(quality, wage, k) {
    const n = quality.length;
    const workers = quality.map((q, i) => [wage[i] / q, q]).sort((a, b) => a[0] - b[0]);
    const maxHeap = new MaxPriorityQueue({priority: x => x});
    let qualitySum = 0, ans = Infinity;
    for (const [ratio, q] of workers) {
        maxHeap.enqueue(q);
        qualitySum += q;
        if (maxHeap.size() > k) {
            qualitySum -= maxHeap.dequeue().element;
        }
        if (maxHeap.size() === k) {
            ans = Math.min(ans, qualitySum * ratio);
        }
    }
    return ans;
};
