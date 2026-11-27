// https://leetcode.com/problems/minimum-difficulty-of-a-job-schedule/

var minDifficulty = function(jd, d) {
    const n=jd.length;
    if (n<d) return -1;
    const INF=Infinity;
    const dp=Array.from({length:d+1},()=>new Array(n+1).fill(INF));
    dp[0][0]=0;
    for (let k=1;k<=d;k++) for (let j=k;j<=n;j++) {
        let mx=0;
        for (let i=j-1;i>=k-1;i--) {
            mx=Math.max(mx,jd[i]);
            if (dp[k-1][i]<INF) dp[k][j]=Math.min(dp[k][j],dp[k-1][i]+mx);
        }
    }
    return dp[d][n]===INF?-1:dp[d][n];
};
