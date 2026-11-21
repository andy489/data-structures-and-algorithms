// https://leetcode.com/problems/factorial-trailing-zeroes/

// Count factors of 5 — O(log n) time, O(1) space
var trailingZeroes = function(n) {
    let count = 0;
    while (n >= 5) { n = Math.floor(n / 5); count += n; }
    return count;
};
