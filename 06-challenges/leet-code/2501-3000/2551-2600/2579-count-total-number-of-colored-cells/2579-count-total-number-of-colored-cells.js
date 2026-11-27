// https://leetcode.com/problems/count-total-number-of-colored-cells/

/**
 * @param {number} n
 * @return {number}
 */
var coloredCells = function(n) {
    return 1 + 2 * n * (n - 1);
};
