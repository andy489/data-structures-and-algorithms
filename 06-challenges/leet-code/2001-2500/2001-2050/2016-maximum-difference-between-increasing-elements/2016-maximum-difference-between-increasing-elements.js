// https://leetcode.com/problems/maximum-difference-between-increasing-elements/

// Solution: Track Running Minimum — O(n) time, O(1) space
var maximumDifference = function(nums) {
    let minVal = nums[0], res = -1;
    for (let j = 1; j < nums.length; j++) {
        if (nums[j] > minVal) res = Math.max(res, nums[j] - minVal);
        minVal = Math.min(minVal, nums[j]);
    }
    return res;
};
