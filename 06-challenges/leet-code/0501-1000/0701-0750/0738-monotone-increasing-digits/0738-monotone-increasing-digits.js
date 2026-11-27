// https://leetcode.com/problems/monotone-increasing-digits/

var monotoneIncreasingDigits = function(n) {
    const digits = n.toString().split('');
    let mark = digits.length;
    for (let i = digits.length - 1; i > 0; i--) {
        if (digits[i - 1] > digits[i]) {
            digits[i - 1] = String(Number(digits[i - 1]) - 1);
            mark = i;
        }
    }
    for (let i = mark; i < digits.length; i++) {
        digits[i] = '9';
    }
    return parseInt(digits.join(''));
};
