// https://leetcode.com/problems/count-commas-in-range-ii/

/**
 * @param {number} n
 * @return {number}
 */
var countCommas = function(n) {
    let result = 0;
    let threshold = 1000;
    while (threshold <= n) {
        result += n - threshold + 1;
        threshold *= 1000;
    }
    return result;
};
