// https://leetcode.com/problems/minimum-falling-path-sum-ii/

var minFallingPathSum = function(grid) {
    const n = grid.length;
    let dp = [...grid[0]];
    for (let i = 1; i < n; i++) {
        let min1=Infinity, min2=Infinity, minCol=-1;
        for (let j=0; j<n; j++) {
            if(dp[j]<min1){min2=min1;min1=dp[j];minCol=j;}
            else if(dp[j]<min2){min2=dp[j];}
        }
        dp = grid[i].map((v,j) => v + (j===minCol?min2:min1));
    }
    return Math.min(...dp);
};
