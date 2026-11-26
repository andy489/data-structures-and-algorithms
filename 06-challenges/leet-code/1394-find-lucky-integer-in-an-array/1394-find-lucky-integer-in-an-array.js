// https://leetcode.com/problems/find-lucky-integer-in-an-array/

var findLucky = function(arr) {
    const cnt=new Map();
    for(const v of arr) cnt.set(v,(cnt.get(v)||0)+1);
    let ans=-1;
    for(const[v,f]of cnt) if(v===f) ans=Math.max(ans,v);
    return ans;
};
