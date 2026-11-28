// https://leetcode.com/problems/length-of-the-longest-subsequence-that-sums-to-target/

var lengthOfLongestSubsequence = function(nums, target) {
    const dp = new Array(target + 1).fill(-Infinity);
    dp[0] = 0;

    for (const num of nums) {
        for (let s = target; s >= num; s--) {
            if (dp[s - num] !== -Infinity) {
                dp[s] = Math.max(dp[s], dp[s - num] + 1);
            }
        }
    }
    return dp[target] < 0 ? -1 : dp[target];
};
