// https://leetcode.com/problems/is-subsequence/

// Solution: Two Pointers — O(t) time, O(1) space
var isSubsequence = function(s, t) {
    let i = 0;
    for (const c of t) {
        if (i < s.length && c === s[i]) i++;
    }
    return i === s.length;
};
