// https://leetcode.com/problems/maximum-sum-of-alternating-subsequence-with-distance-at-least-k/
/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number}
 */
var maximumAlternatingSubsequenceSum = function(nums, k) {
    const n = nums.length;
    const up = new Array(n).fill(-Infinity);
    const down = new Array(n).fill(-Infinity);
    let ans = 0;
    for (let i = 0; i < n; i++) {
        up[i] = nums[i];
        down[i] = nums[i];
        for (let j = 0; j <= i - k; j++) {
            if (nums[j] < nums[i] && down[j] > -Infinity) {
                up[i] = Math.max(up[i], down[j] + nums[i]);
            }
            if (nums[j] > nums[i] && up[j] > -Infinity) {
                down[i] = Math.max(down[i], up[j] + nums[i]);
            }
        }
        ans = Math.max(ans, up[i], down[i]);
    }
    return ans;
};
