// https://leetcode.com/problems/count-substrings-starting-and-ending-with-given-character/

var countSubstrings = function(s, c) {
    const k = [...s].filter(ch => ch === c).length;
    return k * (k + 1) / 2;
};
