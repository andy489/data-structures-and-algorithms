// https://leetcode.com/problems/house-robber/

// Solution 1: DP — O(n) time, O(1) space
var rob = function(nums) {
    let prev2 = 0, prev1 = 0;
    for (const num of nums) {
        const curr = Math.max(prev1, prev2 + num);
        prev2 = prev1;
        prev1 = curr;
    }
    return prev1;
};

// Solution 2: DP array — O(n) time, O(n) space
var rob2 = function(nums) {
    const n = nums.length;
    if (n === 1) return nums[0];
    const dp = new Array(n);
    dp[0] = nums[0];
    dp[1] = Math.max(nums[0], nums[1]);
    for (let i = 2; i < n; i++) {
        dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
    }
    return dp[n - 1];
};
