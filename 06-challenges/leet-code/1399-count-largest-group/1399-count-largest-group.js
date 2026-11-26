// https://leetcode.com/problems/count-largest-group/

var countLargestGroup = function(n) {
    const dsum=x=>[...String(x)].reduce((s,d)=>s+Number(d),0);
    const cnt=new Map();
    for(let i=1;i<=n;i++){const k=dsum(i);cnt.set(k,(cnt.get(k)||0)+1);}
    const max=Math.max(...cnt.values());
    return [...cnt.values()].filter(v=>v===max).length;
};
