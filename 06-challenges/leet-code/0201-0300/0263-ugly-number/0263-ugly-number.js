// https://leetcode.com/problems/ugly-number/

// Solution: Repeated Division — O(log n) time, O(1) space
var isUgly = function(n) {
    if (n <= 0) return false;
    for (const f of [2, 3, 5]) {
        while (n % f === 0) n /= f;
    }
    return n === 1;
};
