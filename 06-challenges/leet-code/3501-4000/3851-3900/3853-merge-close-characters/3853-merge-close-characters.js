// https://leetcode.com/problems/merge-close-characters/

/**
 * @param {string} s
 * @param {number} k
 * @return {string}
 */
var mergeCloseCharacters = function(s, k) {
    let chars = s.split('');
    let merged = true;
    while (merged) {
        merged = false;
        outer:
        for (let i = 0; i < chars.length; i++) {
            for (let j = i + 1; j <= Math.min(i + k, chars.length - 1); j++) {
                if (chars[i] === chars[j]) {
                    chars.splice(j, 1);
                    merged = true;
                    break outer;
                }
            }
        }
    }
    return chars.join('');
};
