// https://leetcode.com/problems/smallest-number-with-all-set-bits/

var smallestNumber = function(n) {
    const bitLen = 32 - Math.clz32(n);
    return (1 << bitLen) - 1;
};
