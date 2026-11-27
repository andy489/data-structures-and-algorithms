// https://leetcode.com/problems/largest-sum-of-averages/

var largestSumOfAverages = function(nums, k) {
    const n = nums.length;
    const prefix = new Array(n + 1).fill(0);
    for (let i = 0; i < n; i++) { prefix[i + 1] = prefix[i] + nums[i]; }
    const dp = Array.from({length: n + 1}, (_, i) => i > 0 ? prefix[i] / i : 0);
    for (let p = 1; p < k; p++) {
        for (let j = n; j > 0; j--) {
            for (let m = 0; m < j; m++) {
                dp[j] = Math.max(dp[j], dp[m] + (prefix[j] - prefix[m]) / (j - m));
            }
        }
    }
    return dp[n];
};
