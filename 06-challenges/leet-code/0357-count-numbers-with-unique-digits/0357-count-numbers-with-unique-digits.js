// https://leetcode.com/problems/count-numbers-with-unique-digits/

// Solution: Combinatorics — O(1) time, O(1) space
var countNumbersWithUniqueDigits = function(n) {
    if (n === 0) return 1;
    let count = 10, unique = 9, available = 9;
    for (let i = 2; i <= n; i++) {
        unique *= available;
        count += unique;
        available--;
    }
    return count;
};
