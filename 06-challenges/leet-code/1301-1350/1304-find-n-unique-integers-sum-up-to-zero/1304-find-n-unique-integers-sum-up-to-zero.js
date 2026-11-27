// https://leetcode.com/problems/find-n-unique-integers-sum-up-to-zero/

var sumZero = function(n) {
    const res = Array.from({length: n-1}, (_, i) => i+1);
    res.push(-res.reduce((a,b)=>a+b,0));
    return res;
};
