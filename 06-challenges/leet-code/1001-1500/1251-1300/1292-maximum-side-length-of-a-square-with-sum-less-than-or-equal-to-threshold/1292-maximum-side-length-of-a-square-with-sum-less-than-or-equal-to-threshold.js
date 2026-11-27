// https://leetcode.com/problems/maximum-side-length-of-a-square-with-sum-less-than-or-equal-to-threshold/

var maxSideLength = function(mat, threshold) {
    const m=mat.length,n=mat[0].length;
    const pre=Array.from({length:m+1},()=>new Array(n+1).fill(0));
    for(let i=1;i<=m;i++) for(let j=1;j<=n;j++) pre[i][j]=mat[i-1][j-1]+pre[i-1][j]+pre[i][j-1]-pre[i-1][j-1];
    let res=0;
    for(let k=1;k<=Math.min(m,n);k++){
        let found=false;
        for(let i=k;i<=m&&!found;i++) for(let j=k;j<=n&&!found;j++) if(pre[i][j]-pre[i-k][j]-pre[i][j-k]+pre[i-k][j-k]<=threshold){res=k;found=true;}
        if(!found)break;
    }
    return res;
};
