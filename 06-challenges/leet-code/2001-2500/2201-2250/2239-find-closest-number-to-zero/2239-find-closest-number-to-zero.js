// https://leetcode.com/problems/find-closest-number-to-zero/

/**
 * @param {number[]} nums
 * @return {number}
 */
var findClosestNumber = function(nums) {
    let best = nums[0];
    for (const x of nums) {
        if (Math.abs(x) < Math.abs(best) || (Math.abs(x) === Math.abs(best) && x > best)) {
            best = x;
        }
    }
    return best;
};
