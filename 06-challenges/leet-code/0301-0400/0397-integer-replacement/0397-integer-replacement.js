// https://leetcode.com/problems/integer-replacement/

// Solution: Greedy / Bit Manipulation — O(log n) time, O(1) space
var integerReplacement = function(n) {
    let ops = 0;
    while (n !== 1) {
        if ((n & 1) === 0) {
            n = Math.floor(n / 2);
        } else if (n === 3 || (n & 3) === 1) {
            n--;
        } else {
            n++;
        }
        ops++;
    }
    return ops;
};
