// https://leetcode.com/problems/valid-digit-number/
/**
 * @param {number} n
 * @param {number} x
 * @return {boolean}
 */
var validDigitNumber = function(n, x) {
    const s = n.toString();
    const cx = x.toString();
    return s.includes(cx) && s[0] !== cx;
};
