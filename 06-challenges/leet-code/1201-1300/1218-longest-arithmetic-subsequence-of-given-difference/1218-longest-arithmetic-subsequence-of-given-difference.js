// https://leetcode.com/problems/longest-arithmetic-subsequence-of-given-difference/

var longestSubsequence = function(arr, difference) {
    const dp = new Map();
    let res = 1;
    for (const x of arr) {
        const len = (dp.get(x - difference) || 0) + 1;
        dp.set(x, len);
        res = Math.max(res, len);
    }
    return res;
};
