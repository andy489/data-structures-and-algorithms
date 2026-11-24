// https://leetcode.com/problems/maximum-product-of-three-numbers/

var maximumProduct = function(nums) {
    nums.sort((a, b) => a - b);
    const n = nums.length;
    const topThree = nums[n - 1] * nums[n - 2] * nums[n - 3];
    const twoSmallest = nums[0] * nums[1] * nums[n - 1];
    return Math.max(topThree, twoSmallest);
};
