// https://leetcode.com/problems/divide-array-in-sets-of-k-consecutive-numbers/

var isPossibleDivide = function(nums, k) {
    if(nums.length%k)return false;
    const count=new Map();for(const x of nums)count.set(x,(count.get(x)||0)+1);
    const sorted=[...count.keys()].sort((a,b)=>a-b);
    for(const x of sorted){
        const c=count.get(x);
        if(c>0) for(let i=0;i<k;i++){
            if((count.get(x+i)||0)<c)return false;
            count.set(x+i,count.get(x+i)-c);
        }
    }
    return true;
};
