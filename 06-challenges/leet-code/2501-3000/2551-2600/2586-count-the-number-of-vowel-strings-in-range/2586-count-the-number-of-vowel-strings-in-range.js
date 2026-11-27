// https://leetcode.com/problems/count-the-number-of-vowel-strings-in-range/
/**
 * @param {string[]} words
 * @param {number} left
 * @param {number} right
 * @return {number}
 */
var vowelStrings = function(words, left, right) {
    const vowels = new Set(['a', 'e', 'i', 'o', 'u']);
    let count = 0;
    for (let i = left; i <= right; i++) {
        const w = words[i];
        if (vowels.has(w[0]) && vowels.has(w[w.length - 1])) {
            count++;
        }
    }
    return count;
};
