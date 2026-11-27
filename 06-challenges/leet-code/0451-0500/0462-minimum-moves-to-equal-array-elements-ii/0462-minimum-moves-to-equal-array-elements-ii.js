// https://leetcode.com/problems/minimum-moves-to-equal-array-elements-ii/

var minMoves2 = function(nums) {
    nums.sort((a, b) => a - b);
    const median = nums[Math.floor(nums.length / 2)];
    return nums.reduce((sum, n) => sum + Math.abs(n - median), 0);
};
