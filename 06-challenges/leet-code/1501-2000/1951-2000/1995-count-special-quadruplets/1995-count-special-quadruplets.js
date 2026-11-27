// https://leetcode.com/problems/count-special-quadruplets/
/**
 * @param {number[]} nums
 * @return {number}
 */
var countQuadruplets = function(nums) {
    const n = nums.length;
    let count = 0;
    const freq = new Map();
    for (let c = n - 2; c >= 2; c--) {
        for (let d = c + 1; d < n; d++) {
            const key = nums[d] - nums[c];
            freq.set(key, (freq.get(key) || 0) + 1);
        }
        for (let a = 0; a < c - 1; a++) {
            for (let b = a + 1; b < c; b++) {
                count += freq.get(nums[a] + nums[b]) || 0;
            }
        }
        freq.clear();
    }
    return count;
};
