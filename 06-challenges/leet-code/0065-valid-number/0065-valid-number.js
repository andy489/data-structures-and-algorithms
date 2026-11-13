// https://leetcode.com/problems/valid-number/

var isNumber = function(s) {
    let seenDigit = false, seenDot = false, seenE = false;
    for (let i = 0; i < s.length; i++) {
        const c = s[i];
        if (c === '+' || c === '-') {
            if (i !== 0 && s[i - 1] !== 'e' && s[i - 1] !== 'E') return false;
        } else if (c === '.') {
            if (seenDot || seenE) return false;
            seenDot = true;
        } else if (c === 'e' || c === 'E') {
            if (seenE || !seenDigit) return false;
            seenE = true;
            seenDigit = false;
        } else if (c >= '0' && c <= '9') {
            seenDigit = true;
        } else {
            return false;
        }
    }
    return seenDigit;
};
