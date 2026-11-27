// https://leetcode.com/problems/minimum-operations-to-sort-a-string/

/**
 * @param {string} s
 * @return {number}
 */
var minimumOperations = function(s) {
    const n = s.length;
    if (n === 1) return 0;
    const sorted = s.split('').sort().join('');
    if (s === sorted) return 0;
    if (n === 2) return -1;
    let descents = 0;
    for (let i = 0; i < n - 1; i++) {
        if (s[i] > s[i + 1]) descents++;
    }
    return descents;
};
