// https://leetcode.com/problems/find-valid-pair-of-adjacent-digits-in-string/
/**
 * @param {string} s
 * @return {string}
 */
var findValidPair = function(s) {
    const freq = new Array(10).fill(0);
    for (const c of s) {
        freq[parseInt(c)]++;
    }
    for (let i = 0; i < s.length - 1; i++) {
        const a = parseInt(s[i]);
        const b = parseInt(s[i + 1]);
        if (a !== b && freq[a] === a && freq[b] === b) {
            return s[i] + s[i + 1];
        }
    }
    return '';
};
