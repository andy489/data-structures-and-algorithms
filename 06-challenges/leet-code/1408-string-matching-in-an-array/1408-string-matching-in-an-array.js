// https://leetcode.com/problems/string-matching-in-an-array/

var stringMatching = function(words) {
    return words.filter(w => words.some(other => other !== w && other.includes(w)));
};
