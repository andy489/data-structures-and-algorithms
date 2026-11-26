// https://leetcode.com/problems/find-the-smallest-divisor-given-a-threshold/

var smallestDivisor = function(nums, threshold) {
    let lo = 1, hi = Math.max(...nums);
    while (lo < hi) {
        const mid = (lo + hi) >> 1;
        const s = nums.reduce((a, x) => a + Math.ceil(x/mid), 0);
        if (s <= threshold) hi = mid; else lo = mid + 1;
    }
    return lo;
};
