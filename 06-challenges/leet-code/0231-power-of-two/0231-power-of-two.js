// https://leetcode.com/problems/power-of-two/

// Solution 1: Bit Trick — O(1) time, O(1) space
var isPowerOfTwo = function(n) {
    return n > 0 && (n & (n - 1)) === 0;
};

// Solution 2: Lowest Set Bit — O(1) time, O(1) space
var isPowerOfTwo2 = function(n) {
    return n > 0 && (n & (-n)) === n;
};

// Solution 3: Integer Logarithm — O(1) time, O(1) space
var isPowerOfTwo3 = function(n) {
    return n > 0 && (1 << 30) % n === 0;
};

// Solution 4: Built-in Popcount — O(1) time, O(1) space
var isPowerOfTwo4 = function(n) {
    return n > 0 && n.toString(2).split('0').join('').length === 1;
};
