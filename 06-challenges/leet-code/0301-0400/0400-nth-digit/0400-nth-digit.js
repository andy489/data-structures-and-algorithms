// https://leetcode.com/problems/nth-digit/

// Solution: Math — O(log n) time, O(1) space
var findNthDigit = function(n) {
    let digits = 1, start = 1, count = 9;
    while (n > digits * count) {
        n -= digits * count;
        digits++;
        start *= 10;
        count *= 10;
    }
    const num = start + Math.floor((n - 1) / digits);
    const digitIndex = (n - 1) % digits;
    return Number(String(num)[digitIndex]);
};
