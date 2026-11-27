// https://leetcode.com/problems/check-adjacent-digit-differences/

/**
 * @param {string} s
 * @return {boolean}
 */
var checkAdjacentDifferences = function(s) {
    for (let i = 1; i < s.length; i++) {
        if (Math.abs(s.charCodeAt(i) - s.charCodeAt(i - 1)) > 2) {
            return false;
        }
    }
    return true;
};
