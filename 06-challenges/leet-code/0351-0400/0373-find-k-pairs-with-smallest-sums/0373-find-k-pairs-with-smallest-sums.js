// https://leetcode.com/problems/find-k-pairs-with-smallest-sums/

// Solution: Min-Heap — O(k log k) time, O(k) space
var kSmallestPairs = function(nums1, nums2, k) {
    // Min-heap: [sum, i, j]
    const heap = [];
    const push = (s, i, j) => {
        heap.push([s, i, j]);
        let idx = heap.length - 1;
        while (idx > 0) {
            const parent = (idx - 1) >> 1;
            if (heap[parent][0] <= heap[idx][0]) break;
            [heap[parent], heap[idx]] = [heap[idx], heap[parent]];
            idx = parent;
        }
    };
    const pop = () => {
        const top = heap[0];
        const last = heap.pop();
        if (heap.length) {
            heap[0] = last;
            let idx = 0;
            while (true) {
                let smallest = idx;
                const l = 2 * idx + 1, r = 2 * idx + 2;
                if (l < heap.length && heap[l][0] < heap[smallest][0]) smallest = l;
                if (r < heap.length && heap[r][0] < heap[smallest][0]) smallest = r;
                if (smallest === idx) break;
                [heap[idx], heap[smallest]] = [heap[smallest], heap[idx]];
                idx = smallest;
            }
        }
        return top;
    };

    for (let i = 0; i < Math.min(k, nums1.length); i++) {
        push(nums1[i] + nums2[0], i, 0);
    }
    const result = [];
    while (heap.length && result.length < k) {
        const [, i, j] = pop();
        result.push([nums1[i], nums2[j]]);
        if (j + 1 < nums2.length) push(nums1[i] + nums2[j + 1], i, j + 1);
    }
    return result;
};
