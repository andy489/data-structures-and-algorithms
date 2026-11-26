// https://leetcode.com/problems/minimum-score-by-changing-two-elements/

// Solution: Sort + Four-Case Minimum — O(n log n) time, O(1) space
var minimizeSum = function(nums) {
    nums.sort((a, b) => a - b);
    const n = nums.length;
    return Math.min(nums[n - 3] - nums[0],
                    nums[n - 2] - nums[1],
                    nums[n - 1] - nums[2]);
};
