// https://leetcode.com/problems/split-a-string-in-balanced-strings/

var balancedStringSplit = function(s) {
    let balance = 0, res = 0;
    for (const c of s) {
        balance += c === 'R' ? 1 : -1;
        if (balance === 0) res++;
    }
    return res;
};
