// https://leetcode.com/problems/number-of-even-and-odd-bits/
/**
 * @param {number} n
 * @return {number[]}
 */
var evenOddBit = function(n) {
    let even = 0, odd = 0;
    for (let i = 0; n > 0; i++, n >>= 1) {
        if (n & 1) {
            if (i % 2 === 0) {
                even++;
            } else {
                odd++;
            }
        }
    }
    return [even, odd];
};
