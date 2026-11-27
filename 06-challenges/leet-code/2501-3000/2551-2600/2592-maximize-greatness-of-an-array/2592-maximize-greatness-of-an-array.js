// https://leetcode.com/problems/maximize-greatness-of-an-array/
/**
 * @param {number[]} nums
 * @return {number}
 */
var maximizeGreatness = function(nums) {
    nums.sort((a, b) => a - b);
    let p = 0;
    for (const num of nums) {
        if (num > nums[p]) {
            p++;
        }
    }
    return p;
};
