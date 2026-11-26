// https://leetcode.com/problems/maximum-length-of-repeated-subarray/

var findLength = function(nums1, nums2) {
    const m = nums1.length, n = nums2.length;
    const dp = Array.from({ length: m + 1 }, () => new Array(n + 1).fill(0));
    let ans = 0;
    for (let i = 1; i <= m; i++) {
        for (let j = 1; j <= n; j++) {
            if (nums1[i-1] === nums2[j-1]) {
                dp[i][j] = dp[i-1][j-1] + 1;
                ans = Math.max(ans, dp[i][j]);
            }
        }
    }
    return ans;
};
