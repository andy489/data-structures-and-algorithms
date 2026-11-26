// https://leetcode.com/problems/paint-house-iii/

var minCost = function(houses, cost, m, n, target) {
    const INF=1e9;
    const dp=Array.from({length:m},()=>Array.from({length:n+1},()=>new Array(target+1).fill(INF)));
    for(let c=1;c<=n;c++)
        if(!houses[0]||houses[0]===c)
            dp[0][c][1]=houses[0]?0:cost[0][c-1];
    for(let i=1;i<m;i++)
        for(let c=1;c<=n;c++){
            if(houses[i]&&houses[i]!==c)continue;
            const pc=houses[i]?0:cost[i][c-1];
            for(let k=1;k<=Math.min(i+1,target);k++)
                for(let p=1;p<=n;p++){
                    if(p===c&&dp[i-1][p][k]<INF)dp[i][c][k]=Math.min(dp[i][c][k],dp[i-1][p][k]+pc);
                    if(p!==c&&k>1&&dp[i-1][p][k-1]<INF)dp[i][c][k]=Math.min(dp[i][c][k],dp[i-1][p][k-1]+pc);
                }
        }
    const ans=Math.min(...Array.from({length:n},(_,i)=>dp[m-1][i+1][target]));
    return ans>=INF?-1:ans;
};
