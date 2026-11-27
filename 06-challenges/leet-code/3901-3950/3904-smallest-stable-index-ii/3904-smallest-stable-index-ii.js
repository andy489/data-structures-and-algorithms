// https://leetcode.com/problems/smallest-stable-index-ii/
/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number}
 */
var smallestStableIndex = function(nums, k) {
    const n = nums.length;
    const suffixMin = new Array(n);
    suffixMin[n - 1] = nums[n - 1];
    for (let i = n - 2; i >= 0; i--) {
        suffixMin[i] = Math.min(suffixMin[i + 1], nums[i]);
    }
    let prefixMax = nums[0];
    for (let i = 0; i < n; i++) {
        if (i > 0) {
            prefixMax = Math.max(prefixMax, nums[i]);
        }
        if (prefixMax - suffixMin[i] <= k) {
            return i;
        }
    }
    return -1;
};
