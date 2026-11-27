// https://leetcode.com/problems/maximum-frequency-of-an-element-after-performing-operations-ii/

// Solution: Sort + Binary Search — O(n log n) time, O(1) space
var maxFrequency = function(nums, k, numOperations) {
    nums.sort((a, b) => a - b);
    const n = nums.length;

    const lowerBound = (val) => {
        let lo = 0, hi = n;
        while (lo < hi) {
            const mid = (lo + hi) >>> 1;
            if (nums[mid] < val) lo = mid + 1; else hi = mid;
        }
        return lo;
    };
    const upperBound = (val) => {
        let lo = 0, hi = n;
        while (lo < hi) {
            const mid = (lo + hi) >>> 1;
            if (nums[mid] <= val) lo = mid + 1; else hi = mid;
        }
        return lo;
    };

    let ans = 0;
    let prev = null;
    for (let i = 0; i < n; i++) {
        const v = nums[i];
        if (v === prev) continue;
        prev = v;
        const lo = lowerBound(v - k);
        const hi = upperBound(v + k);
        const inRange = hi - lo;
        const exact = upperBound(v) - lowerBound(v);
        const needOps = inRange - exact;
        ans = Math.max(ans, exact + Math.min(needOps, numOperations));
    }
    return ans;
};
