// https://leetcode.com/problems/make-array-strictly-increasing/

// Solution: DP with Binary Search — O(n·m·log m) time, O(n·m) space
var makeArrayIncreasing = function(arr1, arr2) {
    const sorted = [...new Set(arr2)].sort((a, b) => a - b);

    function upperBound(arr, target) {
        let lo = 0, hi = arr.length;
        while (lo < hi) {
            const mid = (lo + hi) >> 1;
            if (arr[mid] <= target) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }

    // cloned: Map<ops -> minLastValue>
    let cloned = new Map([[0, -1]]);

    for (const val of arr1) {
        const next = new Map();
        for (const [ops, last] of cloned) {
            // Option 1: keep val
            if (val > last) {
                if (!next.has(ops) || next.get(ops) > val) {
                    next.set(ops, val);
                }
            }
            // Option 2: replace
            const idx = upperBound(sorted, last);
            if (idx < sorted.length) {
                const newOps = ops + 1;
                if (!next.has(newOps) || next.get(newOps) > sorted[idx]) {
                    next.set(newOps, sorted[idx]);
                }
            }
        }
        cloned = next;
        if (cloned.size === 0) {
            return -1;
        }
    }
    return Math.min(...cloned.keys());
};
