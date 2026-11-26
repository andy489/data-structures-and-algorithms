// https://leetcode.com/problems/parallel-courses-ii/

var minNumberOfSemesters = function(n, deps, k) {
    const pre=new Array(n).fill(0);
    for(const[a,b]of deps)pre[b-1]|=1<<(a-1);
    const dp=new Array(1<<n).fill(Infinity);
    dp[0]=0;
    for(let mask=0;mask<(1<<n);mask++){
        if(dp[mask]===Infinity)continue;
        let avail=0;
        for(let i=0;i<n;i++)if(!(mask>>i&1)&&(mask&pre[i])===pre[i])avail|=1<<i;
        for(let sub=avail;sub>0;sub=(sub-1)&avail)
            if(sub.toString(2).split('1').length-1<=k)
                dp[mask|sub]=Math.min(dp[mask|sub],dp[mask]+1);
    }
    return dp[(1<<n)-1];
};
