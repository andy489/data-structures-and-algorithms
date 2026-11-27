// https://leetcode.com/problems/valid-elements-in-an-array/
/**
 * @param {number[]} nums
 * @return {number[]}
 */
var validElements = function(nums) {
    const n = nums.length;
    const prefixMax = new Array(n).fill(-Infinity);
    for (let i = 1; i < n; i++) {
        prefixMax[i] = Math.max(prefixMax[i - 1], nums[i - 1]);
    }
    const suffixMax = new Array(n).fill(-Infinity);
    for (let i = n - 2; i >= 0; i--) {
        suffixMax[i] = Math.max(suffixMax[i + 1], nums[i + 1]);
    }
    return nums.filter((v, i) => v > prefixMax[i] || v > suffixMax[i]);
};
