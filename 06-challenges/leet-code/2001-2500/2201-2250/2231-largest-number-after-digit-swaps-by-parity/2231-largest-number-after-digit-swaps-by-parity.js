// https://leetcode.com/problems/largest-number-after-digit-swaps-by-parity/

/**
 * @param {number} num
 * @return {number}
 */
var largestInteger = function(num) {
    const digits = num.toString().split('').map(Number);
    const odds = digits.filter(d => d % 2 === 1).sort((a, b) => b - a);
    const evens = digits.filter(d => d % 2 === 0).sort((a, b) => b - a);
    let oi = 0, ei = 0;
    const result = digits.map(d => {
        if (d % 2 === 1) {
            return odds[oi++];
        } else {
            return evens[ei++];
        }
    });
    return parseInt(result.join(''));
};
