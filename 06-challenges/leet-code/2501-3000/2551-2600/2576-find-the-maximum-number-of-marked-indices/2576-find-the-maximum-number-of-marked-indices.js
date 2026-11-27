// https://leetcode.com/problems/find-the-maximum-number-of-marked-indices/

/**
 * @param {number[]} nums
 * @return {number}
 */
var maxNumOfMarkedIndices = function(nums) {
    nums.sort((a, b) => a - b);
    const n = nums.length;
    let left = 0;
    let right = Math.floor(n / 2);
    let count = 0;
    while (right < n) {
        if (2 * nums[left] <= nums[right]) {
            count++;
            left++;
        }
        right++;
    }
    return count * 2;
};
