// https://leetcode.com/problems/minimum-swaps-to-move-zeros-to-end/
/**
 * @param {number[]} nums
 * @return {number}
 */
var minimumSwaps = function(nums) {
    let pos = 0;
    let swaps = 0;
    for (let i = 0; i < nums.length; i++) {
        if (nums[i] !== 0) {
            if (i > pos) {
                swaps++;
            }
            pos++;
        }
    }
    return swaps;
};
