// https://leetcode.com/problems/valid-parenthesis-string/

var checkValidString = function(s) {
    let lo = 0, hi = 0;
    for (const c of s) {
        if (c === '(') { lo++; hi++; }
        else if (c === ')') { lo--; hi--; }
        else { lo--; hi++; }
        if (hi < 0) return false;
        lo = Math.max(lo, 0);
    }
    return lo === 0;
};
