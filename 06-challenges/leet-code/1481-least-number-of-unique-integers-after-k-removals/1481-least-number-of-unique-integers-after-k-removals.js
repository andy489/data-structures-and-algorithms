// https://leetcode.com/problems/least-number-of-unique-integers-after-k-removals/

var findLeastNumOfUniqueInts = function(arr, k) {
    const freq = new Map();
    for (const n of arr) freq.set(n, (freq.get(n)||0)+1);
    const counts = [...freq.values()].sort((a,b)=>a-b);
    let unique = counts.length;
    for (const cnt of counts) {
        if (k >= cnt) { k -= cnt; unique--; }
        else break;
    }
    return unique;
};
