// https://leetcode.com/problems/check-if-a-parentheses-string-can-be-valid/
var canBeValid = function(s, locked) {
    const n = s.length;
    if (n % 2 !== 0) return false;
    let lo = 0, hi = 0;
    for (let i = 0; i < n; i++) {
        if (locked[i] === '0') {
            lo--;
            hi++;
        } else if (s[i] === '(') {
            lo++;
            hi++;
        } else {
            lo--;
            hi--;
        }
        if (hi < 0) return false;
        lo = Math.max(lo, 0);
    }
    return lo === 0;
};
