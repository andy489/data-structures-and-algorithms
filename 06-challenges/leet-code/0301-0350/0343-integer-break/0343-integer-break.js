// https://leetcode.com/problems/integer-break/

// Solution: Math (Greedy with 3s) — O(1) time, O(1) space
var integerBreak = function(n) {
    if (n === 2) return 1;
    if (n === 3) return 2;
    let product = 1;
    while (n > 4) {
        product *= 3;
        n -= 3;
    }
    return product * n;
};
