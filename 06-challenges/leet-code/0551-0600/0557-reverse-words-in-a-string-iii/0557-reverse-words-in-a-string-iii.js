// https://leetcode.com/problems/reverse-words-in-a-string-iii/
// Solution: Per-word reverse — O(n) time, O(n) space
var reverseWords = function(s) {
    return s.split(' ').map(word => word.split('').reverse().join('')).join(' ');
};
