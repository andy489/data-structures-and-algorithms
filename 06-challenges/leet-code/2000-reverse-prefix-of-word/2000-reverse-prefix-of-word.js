// https://leetcode.com/problems/reverse-prefix-of-word/

// Solution: Simulation — O(n) time, O(n) space
var reversePrefix = function(word, ch) {
    const i = word.indexOf(ch);
    if (i === -1) return word;
    return word.slice(0, i + 1).split('').reverse().join('') + word.slice(i + 1);
};
