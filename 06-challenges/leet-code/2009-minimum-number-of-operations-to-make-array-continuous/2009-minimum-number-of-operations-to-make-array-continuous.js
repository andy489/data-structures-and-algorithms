// https://leetcode.com/problems/minimum-number-of-operations-to-make-array-continuous/

// Solution: Sort + Sliding Window — O(n log n) time, O(n) space
var minOperations = function(nums) {
    const n = nums.length;
    const sorted = [...new Set(nums)].sort((a, b) => a - b);
    const m = sorted.length;
    let res = n, r = 0;
    for (let l = 0; l < m; l++) {
        while (r < m && sorted[r] < sorted[l] + n) r++;
        res = Math.min(res, n - (r - l));
    }
    return res;
};
