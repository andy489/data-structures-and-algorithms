// https://leetcode.com/problems/greatest-sum-divisible-by-three/

var maxSumDivThree = function(nums) {
    let dp=[0,-Infinity,-Infinity];
    for(const x of nums){
        const ndp=[...dp];
        for(let r=0;r<3;r++) if(dp[r]!==-Infinity) ndp[(r+x)%3]=Math.max(ndp[(r+x)%3],dp[r]+x);
        dp=ndp;
    }
    return dp[0];
};
