// https://leetcode.com/problems/circular-permutation-in-binary-representation/

var circularPermutation = function(n, start) {
    return Array.from({length:1<<n},(_,i)=>start^(i^(i>>1)));
};
