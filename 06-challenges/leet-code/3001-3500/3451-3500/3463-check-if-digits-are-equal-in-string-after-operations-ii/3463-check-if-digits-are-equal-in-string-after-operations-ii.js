// https://leetcode.com/problems/check-if-digits-are-equal-in-string-after-operations-ii/

var hasSameDigits = function(s) {
    const n = s.length;
    const digits = s.split('').map(Number);
    const length = n - 2;

    const binom = new Array(length + 1).fill(0);
    binom[0] = 1;
    for (let r = 1; r <= length; r++) {
        for (let col = r; col >= 1; col--) {
            binom[col] = (binom[col] + binom[col - 1]) % 10;
        }
    }

    let d0 = 0, d1 = 0;
    for (let i = 0; i <= length; i++) {
        d0 = (d0 + binom[i] * digits[i]) % 10;
        d1 = (d1 + binom[i] * digits[i + 1]) % 10;
    }
    return d0 === d1;
};
