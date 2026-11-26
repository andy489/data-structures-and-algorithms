// https://leetcode.com/problems/number-of-ways-to-stay-in-the-same-place-after-some-steps/

var numWays = function(steps, arrLen) {
    const MOD=1000000007n, maxPos=Math.min(steps>>1,arrLen-1);
    let dp=new Array(maxPos+1).fill(0n); dp[0]=1n;
    for(let s=0;s<steps;s++){
        const ndp=new Array(maxPos+1).fill(0n);
        for(let j=0;j<=maxPos;j++){
            if(!dp[j])continue;
            ndp[j]=(ndp[j]+dp[j])%MOD;
            if(j>0)ndp[j-1]=(ndp[j-1]+dp[j])%MOD;
            if(j<maxPos)ndp[j+1]=(ndp[j+1]+dp[j])%MOD;
        }
        dp=ndp;
    }
    return Number(dp[0]);
};
