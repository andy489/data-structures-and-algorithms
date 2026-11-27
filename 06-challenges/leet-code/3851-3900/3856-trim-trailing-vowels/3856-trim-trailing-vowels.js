// https://leetcode.com/problems/trim-trailing-vowels/

/**
 * @param {string} s
 * @return {string}
 */
var trimTrailingVowels = function(s) {
    const vowels = new Set(['a', 'e', 'i', 'o', 'u']);
    let i = s.length - 1;
    while (i >= 0 && vowels.has(s[i])) {
        i--;
    }
    return s.substring(0, i + 1);
};
