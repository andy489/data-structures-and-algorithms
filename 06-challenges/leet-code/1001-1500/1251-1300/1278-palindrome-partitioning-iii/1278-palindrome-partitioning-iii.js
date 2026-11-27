// https://leetcode.com/problems/palindrome-partitioning-iii/

var palindromePartition = function(s, k) {
    const n=s.length,INF=Infinity;
    const cost=Array.from({length:n},()=>new Array(n).fill(0));
    for(let len=2;len<=n;len++) for(let i=0;i+len-1<n;i++){const j=i+len-1;cost[i][j]=cost[i+1]?.[j-1]||0+(s[i]===s[j]?0:1);}
    const dp=Array.from({length:n},()=>new Array(k+1).fill(INF));
    for(let i=0;i<n;i++) dp[i][1]=cost[0][i];
    for(let j=2;j<=k;j++) for(let i=j-1;i<n;i++) for(let m=j-2;m<i;m++) if(dp[m][j-1]!==INF) dp[i][j]=Math.min(dp[i][j],dp[m][j-1]+cost[m+1][i]);
    return dp[n-1][k];
};
