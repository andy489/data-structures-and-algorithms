// https://leetcode.com/problems/jump-game/

var canJump = function(nums) {
    let maxReach = 0;
    for (let i = 0; i < nums.length; i++) {
        if (i > maxReach) return false;
        maxReach = Math.max(maxReach, i + nums[i]);
    }
    return true;
};

// Solution 2: Greedy Right-to-Left — O(n) time, O(1) space
var canJump2 = function(nums) {
    let goal = nums.length - 1;
    for (let i = nums.length - 2; i >= 0; i--) {
        if (i + nums[i] >= goal) goal = i;
    }
    return goal === 0;
};
