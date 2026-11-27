// https://leetcode.com/problems/partition-array-for-maximum-sum/

var maxSumAfterPartitioning = function(arr, k) {
    const n = arr.length, dp = new Array(n+1).fill(0);
    for (let i = 1; i <= n; i++) {
        let maxVal = 0;
        for (let j = 1; j <= k && i-j >= 0; j++) {
            maxVal = Math.max(maxVal, arr[i-j]);
            dp[i] = Math.max(dp[i], dp[i-j] + maxVal * j);
        }
    }
    return dp[n];
};
