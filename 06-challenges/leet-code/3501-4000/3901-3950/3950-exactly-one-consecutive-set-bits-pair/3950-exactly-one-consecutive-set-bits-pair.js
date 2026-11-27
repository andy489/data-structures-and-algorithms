// https://leetcode.com/problems/exactly-one-consecutive-set-bits-pair/
/**
 * @param {number} n
 * @return {boolean}
 */
var hasExactlyOneConsecutivePair = function(n) {
    const pairs = n & (n >> 1);
    return (pairs & (pairs - 1)) === 0 && pairs !== 0;
};
