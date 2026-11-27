// https://leetcode.com/problems/compare-sums-of-bitonic-parts/
/**
 * @param {number[]} nums
 * @return {number}
 */
var compareSums = function(nums) {
    const n = nums.length;
    let peak = 0;
    for (let i = 0; i < n - 1; i++) {
        if (nums[i] > nums[i + 1]) {
            peak = i;
            break;
        }
        peak = i + 1;
    }
    let ascSum = 0, descSum = 0;
    for (let i = 0; i <= peak; i++) { ascSum += nums[i]; }
    for (let i = peak; i < n; i++) { descSum += nums[i]; }
    if (ascSum > descSum) { return 0; }
    if (descSum > ascSum) { return 1; }
    return -1;
};
