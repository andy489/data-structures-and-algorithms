// https://leetcode.com/problems/maximum-ascending-subarray-sum/

var maxAscendingSum = function(nums) {
    let curSum = nums[0];
    let ans = nums[0];
    for (let i = 1; i < nums.length; i++) {
        if (nums[i] > nums[i - 1]) {
            curSum += nums[i];
        } else {
            curSum = nums[i];
        }
        ans = Math.max(ans, curSum);
    }
    return ans;
};
