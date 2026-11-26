// https://leetcode.com/problems/sort-integers-by-the-number-of-1-bits/

var sortByBits = function(arr) {
    const bits = x => x.toString(2).split('').filter(c=>c==='1').length;
    return arr.sort((a,b)=>bits(a)!==bits(b)?bits(a)-bits(b):a-b);
};
