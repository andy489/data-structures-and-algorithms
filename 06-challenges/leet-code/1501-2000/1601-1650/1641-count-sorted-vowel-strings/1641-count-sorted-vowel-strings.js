// https://leetcode.com/problems/count-sorted-vowel-strings/

var countVowelStrings = function(n) {
    // C(n+4, 4)
    return (n + 1) * (n + 2) * (n + 3) * (n + 4) / 24;
};
