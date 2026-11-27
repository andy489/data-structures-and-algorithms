// https://leetcode.com/problems/maximum-equal-frequency/

var maxEqualFreq = function(nums) {
    const count=new Map(),cntCnt=new Map();let maxFreq=0,res=0;
    for(let i=0;i<nums.length;i++){
        const x=nums[i],old=count.get(x)||0;
        if(old>0)cntCnt.set(old,(cntCnt.get(old)||0)-1);
        count.set(x,old+1);cntCnt.set(old+1,(cntCnt.get(old+1)||0)+1);
        maxFreq=Math.max(maxFreq,old+1);
        const n=i+1,cf=cntCnt.get(maxFreq)||0;
        if(maxFreq===1||maxFreq*cf===n-1||(maxFreq+1)===n||maxFreq*cf===n&&cf===1)res=n;
    }
    return res;
};
