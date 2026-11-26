// https://leetcode.com/problems/binary-number-with-alternating-bits/

var hasAlternatingBits = function(n) {
    const x = n ^ (n >> 1);
    return (x & (x + 1)) === 0;
};
