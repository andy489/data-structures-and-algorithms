// https://leetcode.com/problems/allocate-mailboxes/

var minDistance = function(houses, k) {
    houses.sort((a,b)=>a-b);
    const n=houses.length,cost=Array.from({length:n},()=>new Array(n).fill(0));
    for(let i=0;i<n;i++)for(let j=i;j<n;j++){const m=(i+j)>>1;for(let x=i;x<=j;x++)cost[i][j]+=Math.abs(houses[x]-houses[m]);}
    const INF=1e9,dp=Array.from({length:k+1},()=>new Array(n+1).fill(INF));
    dp[0][0]=0;
    for(let i=1;i<=k;i++)for(let j=1;j<=n;j++)for(let p=i-1;p<j;p++)
        if(dp[i-1][p]<INF)dp[i][j]=Math.min(dp[i][j],dp[i-1][p]+cost[p][j-1]);
    return dp[k][n];
};
