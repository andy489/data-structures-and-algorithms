// https://leetcode.com/problems/remove-palindromic-subsequences/

var removePalindromeSub = function(s) {
    if (!s) return 0;
    return s === s.split('').reverse().join('') ? 1 : 2;
};
