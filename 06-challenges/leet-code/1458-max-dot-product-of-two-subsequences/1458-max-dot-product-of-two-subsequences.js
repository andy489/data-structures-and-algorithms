// https://leetcode.com/problems/max-dot-product-of-two-subsequences/

var maxDotProduct = function(nums1, nums2) {
    const n=nums1.length, m=nums2.length, NEG=-(10**9);
    const dp=Array.from({length:n+1},()=>new Array(m+1).fill(NEG));
    for (let i=1;i<=n;i++)
        for (let j=1;j<=m;j++) {
            const prod=nums1[i-1]*nums2[j-1];
            dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1],prod+Math.max(0,dp[i-1][j-1]));
        }
    return dp[n][m];
};
