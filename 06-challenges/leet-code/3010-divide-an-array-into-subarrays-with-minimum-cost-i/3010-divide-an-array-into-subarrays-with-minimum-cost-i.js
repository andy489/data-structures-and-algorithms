// https://leetcode.com/problems/divide-an-array-into-subarrays-with-minimum-cost-i/

var minimumCost = function(nums) {
    const rest = nums.slice(1).sort((a,b) => a-b);
    return nums[0] + rest[0] + rest[1];
};
