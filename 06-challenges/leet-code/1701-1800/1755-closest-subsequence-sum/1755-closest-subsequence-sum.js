// https://leetcode.com/problems/closest-subsequence-sum/

var minAbsDifference = function(nums, goal) {
    function subsetSums(arr) {
        let sums = [0];
        for (const x of arr) {
            const len = sums.length;
            for (let i = 0; i < len; i++) {
                sums.push(sums[i] + x);
            }
        }
        return sums;
    }

    const half = Math.floor(nums.length / 2);
    const leftSums = subsetSums(nums.slice(0, half));
    const rightSums = subsetSums(nums.slice(half)).sort((a, b) => a - b);
    const m = rightSums.length;
    let ans = Infinity;

    for (const ls of leftSums) {
        const target = goal - ls;
        // Binary search for target in rightSums
        let lo = 0, hi = m;
        while (lo < hi) {
            const mid = (lo + hi) >> 1;
            if (rightSums[mid] < target) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        for (const idx of [lo - 1, lo]) {
            if (idx >= 0 && idx < m) {
                ans = Math.min(ans, Math.abs(ls + rightSums[idx] - goal));
            }
        }
        if (ans === 0) return 0;
    }
    return ans;
};
