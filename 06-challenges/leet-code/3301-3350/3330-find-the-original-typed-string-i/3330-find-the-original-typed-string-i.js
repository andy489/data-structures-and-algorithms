// https://leetcode.com/problems/find-the-original-typed-string-i/

/**
 * @param {string} word
 * @return {number}
 */
var possibleStringCount = function(word) {
    let result = 1;
    let i = 0;
    while (i < word.length) {
        let j = i;
        while (j < word.length && word[j] === word[i]) {
            j++;
        }
        if (j - i > 1) {
            result += j - i - 1;
        }
        i = j;
    }
    return result;
};
