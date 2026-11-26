// https://leetcode.com/problems/rotated-digits/

var rotatedDigits = function(n) {
    const invalid = new Set([3, 4, 7]);
    const changing = new Set([2, 5, 6, 9]);
    let count = 0;
    for (let i = 1; i <= n; i++) {
        const digits = String(i).split('').map(Number);
        if (!digits.some(d => invalid.has(d)) && digits.some(d => changing.has(d))) {
            count++;
        }
    }
    return count;
};
