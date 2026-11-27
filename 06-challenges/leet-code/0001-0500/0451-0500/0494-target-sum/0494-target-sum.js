// https://leetcode.com/problems/target-sum/

var findTargetSumWays = function(nums, target) {
    const total = nums.reduce((a, b) => a + b, 0);
    const s = target + total;
    if (s < 0 || s % 2 !== 0) return 0;
    const goal = s / 2;
    const dp = new Array(goal + 1).fill(0);
    dp[0] = 1;
    for (const num of nums) {
        for (let j = goal; j >= num; j--) {
            dp[j] += dp[j - num];
        }
    }
    return dp[goal];
};
