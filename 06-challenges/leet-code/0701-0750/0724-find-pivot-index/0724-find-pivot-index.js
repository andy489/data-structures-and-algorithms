// https://leetcode.com/problems/find-pivot-index/

var pivotIndex = function(nums) {
    const total = nums.reduce((a, b) => a + b, 0);
    let leftSum = 0;
    for (let i = 0; i < nums.length; i++) {
        if (leftSum === total - leftSum - nums[i]) return i;
        leftSum += nums[i];
    }
    return -1;
};
