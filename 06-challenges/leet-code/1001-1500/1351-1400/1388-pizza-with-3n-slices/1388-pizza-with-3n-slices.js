// https://leetcode.com/problems/pizza-with-3n-slices/

var maxSizeSlices = function(slices) {
    const n=slices.length/3;
    const pick=arr=>{
        const m=arr.length;
        const dp=Array.from({length:m+1},()=>new Array(n+1).fill(0));
        for(let i=1;i<=m;i++) for(let j=1;j<=n;j++)
            dp[i][j]=Math.max(dp[i-1][j],(i>=2?dp[i-2][j-1]:0)+arr[i-1]);
        return dp[m][n];
    };
    return Math.max(pick(slices.slice(0,-1)),pick(slices.slice(1)));
};
