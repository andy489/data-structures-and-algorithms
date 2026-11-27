// https://leetcode.com/problems/wiggle-subsequence/

// Solution: Greedy — O(n) time, O(1) space
var wiggleMaxLength = function(nums) {
    let up = 1, down = 1;
    for (let i = 1; i < nums.length; i++) {
        if (nums[i] > nums[i - 1]) up = down + 1;
        else if (nums[i] < nums[i - 1]) down = up + 1;
    }
    return Math.max(up, down);
};
