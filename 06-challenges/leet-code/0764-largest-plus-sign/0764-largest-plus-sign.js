// https://leetcode.com/problems/largest-plus-sign/

var orderOfLargestPlusSign = function(n, mines) {
    const mineSet = new Set(mines.map(([r,c]) => r*n+c));
    const dp = Array.from({length:n},()=>new Array(n).fill(0));
    let ans = 0;
    for (let r=0;r<n;r++) {
        let cnt=0;
        for (let c=0;c<n;c++) { cnt = mineSet.has(r*n+c)?0:cnt+1; dp[r][c]=cnt; }
        cnt=0;
        for (let c=n-1;c>=0;c--) { cnt=mineSet.has(r*n+c)?0:cnt+1; dp[r][c]=Math.min(dp[r][c],cnt); }
    }
    for (let c=0;c<n;c++) {
        let cnt=0;
        for (let r=0;r<n;r++) { cnt=mineSet.has(r*n+c)?0:cnt+1; dp[r][c]=Math.min(dp[r][c],cnt); }
        cnt=0;
        for (let r=n-1;r>=0;r--) { cnt=mineSet.has(r*n+c)?0:cnt+1; dp[r][c]=Math.min(dp[r][c],cnt); ans=Math.max(ans,dp[r][c]); }
    }
    return ans;
};
