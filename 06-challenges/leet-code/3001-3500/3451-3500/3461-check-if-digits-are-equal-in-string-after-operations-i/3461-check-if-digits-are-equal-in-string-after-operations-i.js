// https://leetcode.com/problems/check-if-digits-are-equal-in-string-after-operations-i/

var hasSameDigits = function(s) {
    let digits = s.split('').map(Number);
    while (digits.length > 2) {
        const next = [];
        for (let i = 0; i < digits.length - 1; i++) {
            next.push((digits[i] + digits[i + 1]) % 10);
        }
        digits = next;
    }
    return digits[0] === digits[1];
};
