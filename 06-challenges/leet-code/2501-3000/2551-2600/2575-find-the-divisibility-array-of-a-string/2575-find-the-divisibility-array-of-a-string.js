// https://leetcode.com/problems/find-the-divisibility-array-of-a-string/

/**
 * @param {string} word
 * @param {number} m
 * @return {number[]}
 */
var divisibilityArray = function(word, m) {
    let remainder = 0;
    const result = [];
    for (const ch of word) {
        remainder = (remainder * 10 + parseInt(ch)) % m;
        result.push(remainder === 0 ? 1 : 0);
    }
    return result;
};
