// https://leetcode.com/problems/valid-palindrome-ii/

var validPalindrome = function(s) {
    function isPalin(lo, hi) {
        while (lo < hi) {
            if (s[lo] !== s[hi]) return false;
            lo++; hi--;
        }
        return true;
    }
    let lo = 0, hi = s.length - 1;
    while (lo < hi) {
        if (s[lo] !== s[hi]) return isPalin(lo + 1, hi) || isPalin(lo, hi - 1);
        lo++; hi--;
    }
    return true;
};
