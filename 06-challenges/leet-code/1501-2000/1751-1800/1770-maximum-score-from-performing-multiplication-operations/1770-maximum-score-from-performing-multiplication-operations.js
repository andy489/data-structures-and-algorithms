// https://leetcode.com/problems/maximum-score-from-performing-multiplication-operations/

var maximumScore = function(nums, multipliers) {
    const n = nums.length, m = multipliers.length;
    const dp = Array.from({length: m + 1}, () => new Array(m + 1).fill(0));
    for (let i = m - 1; i >= 0; i--) {
        for (let l = 0; l <= i; l++) {
            const r = n - 1 - (i - l);
            const pickLeft = multipliers[i] * nums[l] + dp[i + 1][l + 1];
            const pickRight = multipliers[i] * nums[r] + dp[i + 1][l];
            dp[i][l] = Math.max(pickLeft, pickRight);
        }
    }
    return dp[0][0];
};
