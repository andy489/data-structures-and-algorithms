// https://leetcode.com/problems/four-divisors/

var sumFourDivisors = function(nums) {
    const divisors=n=>{
        const res=[];
        for(let d=1;d*d<=n;d++){
            if(n%d===0){res.push(d);if(d!==n/d)res.push(n/d);}
            if(res.length>4) return [];
        }
        return res;
    };
    return nums.reduce((s,n)=>{const d=divisors(n);return d.length===4?s+d.reduce((a,b)=>a+b,0):s;},0);
};
