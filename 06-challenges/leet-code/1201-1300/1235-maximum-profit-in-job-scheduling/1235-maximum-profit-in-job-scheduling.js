// https://leetcode.com/problems/maximum-profit-in-job-scheduling/

var jobScheduling = function(startTime, endTime, profit) {
    const n=startTime.length;
    const jobs=Array.from({length:n},(_,i)=>[endTime[i],startTime[i],profit[i]]).sort((a,b)=>a[0]-b[0]);
    const dp=new Array(n+1).fill(0);
    for(let i=0;i<n;i++){
        let lo=0,hi=i;
        while(lo<hi){const m=(lo+hi+1)>>1;if(jobs[m-1][0]<=jobs[i][1])lo=m;else hi=m-1;}
        dp[i+1]=Math.max(dp[i],dp[lo]+jobs[i][2]);
    }
    return dp[n];
};
