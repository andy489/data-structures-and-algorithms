// https://leetcode.com/problems/sort-integers-by-the-power-value/

var getKth = function(lo, hi, k) {
    const memo=new Map();
    const power=x=>{if(x===1) return 0; if(memo.has(x)) return memo.get(x); const p=1+power(x%2===0?x/2:3*x+1); memo.set(x,p); return p;};
    return Array.from({length:hi-lo+1},(_,i)=>lo+i).sort((a,b)=>power(a)!==power(b)?power(a)-power(b):a-b)[k-1];
};
