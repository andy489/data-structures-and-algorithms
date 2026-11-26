// https://leetcode.com/problems/make-two-arrays-equal-by-reversing-subarrays/

var canBeEqual = function(target, arr) {
    return [...target].sort((a,b)=>a-b).join() === [...arr].sort((a,b)=>a-b).join();
};
