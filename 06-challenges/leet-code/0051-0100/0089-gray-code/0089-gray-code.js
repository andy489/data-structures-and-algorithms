// https://leetcode.com/problems/gray-code/

var grayCode = function(n) {
    const result = [];
    for (let i = 0; i < (1 << n); i++) {
        result.push(i ^ (i >> 1));
    }
    return result;
};

// Solution 2: Recursive Reflection — O(2^n) time, O(2^n) space
var grayCode2 = function(n) {
    const code = [0, 1];
    for (let bit = 1; bit < n; bit++) {
        const size = code.length;
        for (let i = size - 1; i >= 0; i--) {
            code.push((1 << bit) | code[i]);
        }
    }
    return code;
};
