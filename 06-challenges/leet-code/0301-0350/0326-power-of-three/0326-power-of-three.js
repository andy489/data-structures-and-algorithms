// https://leetcode.com/problems/power-of-three/

// Solution 1: Loop — O(log n) time, O(1) space
var isPowerOfThree = function(n) {
    if (n <= 0) return false;
    while (n % 3 === 0) n /= 3;
    return n === 1;
};
