// https://leetcode.com/problems/numbers-at-most-n-given-digit-set/

var atMostNGivenDigitSet = function(digits, n) {
    const s = String(n);
    const L = s.length, d = digits.length;
    let result = 0;
    for (let len = 1; len < L; len++) {
        result += Math.pow(d, len);
    }
    for (let i = 0; i < L; i++) {
        const strictlyLess = digits.filter(dig => dig < s[i]).length;
        result += strictlyLess * Math.pow(d, L - 1 - i);
        if (!digits.includes(s[i])) {
            return result;
        }
    }
    return result + 1;
};
