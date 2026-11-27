// https://leetcode.com/problems/maximum-students-taking-exam/

var maxStudents = function(seats) {
    const m=seats.length, n=seats[0].length;
    const valid=seats.map(row=>row.reduce((v,c,j)=>c==='.'?v|(1<<j):v,0));
    const dp=Array.from({length:m+1},()=>new Array(1<<n).fill(-1));
    dp[0][0]=0;
    let ans=0;
    for(let i=0;i<m;i++) for(let prev=0;prev<(1<<n);prev++){
        if(dp[i][prev]<0) continue;
        for(let cur=0;cur<(1<<n);cur++){
            if((cur&valid[i])!==cur||(cur&(cur>>1))) continue;
            if((prev&(cur<<1))||(prev&(cur>>1))) continue;
            const s=dp[i][prev]+cur.toString(2).split('').filter(x=>x==='1').length;
            if(dp[i+1][cur]<s){dp[i+1][cur]=s;ans=Math.max(ans,s);}
        }
    }
    return ans;
};
