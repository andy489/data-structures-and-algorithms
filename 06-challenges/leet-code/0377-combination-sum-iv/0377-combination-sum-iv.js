// https://leetcode.com/problems/combination-sum-iv/

// Solution: Bottom-Up DP — O(target × n) time, O(target) space
var combinationSum4 = function(nums, target) {
    const dp = new Array(target + 1).fill(0);
    dp[0] = 1;
    for (let i = 1; i <= target; i++) {
        for (const num of nums) {
            if (num <= i) dp[i] += dp[i - num];
        }
    }
    return dp[target];
};
