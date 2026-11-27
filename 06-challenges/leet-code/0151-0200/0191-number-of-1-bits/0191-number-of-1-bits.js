// https://leetcode.com/problems/number-of-1-bits/

// Brian Kernighan — O(k) time, O(1) space
var hammingWeight = function(n) {
    let count = 0;
    while (n !== 0) { n &= (n - 1); count++; }
    return count;
};
