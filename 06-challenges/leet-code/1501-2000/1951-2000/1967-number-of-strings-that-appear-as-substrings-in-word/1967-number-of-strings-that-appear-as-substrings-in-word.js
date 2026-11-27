// https://leetcode.com/problems/number-of-strings-that-appear-as-substrings-in-word/
var numOfStrings = function(patterns, word) {
    return patterns.filter(p => word.includes(p)).length;
};
