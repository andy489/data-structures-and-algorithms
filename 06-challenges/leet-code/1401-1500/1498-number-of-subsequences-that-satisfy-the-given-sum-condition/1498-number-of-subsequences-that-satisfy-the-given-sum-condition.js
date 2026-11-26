// https://leetcode.com/problems/number-of-subsequences-that-satisfy-the-given-sum-condition/

var numSubseq = function(nums, target) {
    const MOD=1000000007n;
    nums.sort((a,b)=>a-b);
    const n=nums.length;
    const pw=new Array(n).fill(1n);
    for(let i=1;i<n;i++)pw[i]=pw[i-1]*2n%MOD;
    let l=0,r=n-1,ans=0n;
    while(l<=r){
        if(nums[l]+nums[r]<=target){ans=(ans+pw[r-l])%MOD;l++;}
        else r--;
    }
    return Number(ans);
};
