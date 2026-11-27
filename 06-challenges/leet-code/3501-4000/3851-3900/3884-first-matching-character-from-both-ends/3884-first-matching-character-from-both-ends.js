// https://leetcode.com/problems/first-matching-character-from-both-ends/

/**
 * @param {string} s
 * @return {number}
 */
var firstMatchingIndex = function(s) {
    const n = s.length;
    for (let i = 0; i < n; i++) {
        if (s[i] === s[n - 1 - i]) { return i; }
    }
    return -1;
};
