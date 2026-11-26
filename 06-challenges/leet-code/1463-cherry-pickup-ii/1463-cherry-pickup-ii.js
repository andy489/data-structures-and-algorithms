// https://leetcode.com/problems/cherry-pickup-ii/

var cherryPickup = function(grid) {
    const R=grid.length,C=grid[0].length;
    const dp=Array.from({length:R},()=>Array.from({length:C},()=>new Array(C).fill(-1)));
    dp[0][0][C-1]=grid[0][0]+(C>1?grid[0][C-1]:0);
    for(let r=0;r<R-1;r++)
        for(let c1=0;c1<C;c1++)
            for(let c2=0;c2<C;c2++){
                if(dp[r][c1][c2]<0)continue;
                for(let d1=-1;d1<=1;d1++)for(let d2=-1;d2<=1;d2++){
                    const nc1=c1+d1,nc2=c2+d2;
                    if(nc1<0||nc1>=C||nc2<0||nc2>=C)continue;
                    const ch=grid[r+1][nc1]+(nc1!==nc2?grid[r+1][nc2]:0);
                    dp[r+1][nc1][nc2]=Math.max(dp[r+1][nc1][nc2],dp[r][c1][c2]+ch);
                }
            }
    return Math.max(...dp[R-1].flat());
};
