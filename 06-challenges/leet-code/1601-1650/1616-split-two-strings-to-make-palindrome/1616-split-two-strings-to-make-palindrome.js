// https://leetcode.com/problems/split-two-strings-to-make-palindrome/

var checkPalindromeFormation = function(a, b) {
    function isPalindrome(s, l, r) {
        while (l < r) {
            if (s[l++] !== s[r--]) return false;
        }
        return true;
    }
    function check(a, b) {
        let l = 0, r = a.length - 1;
        while (l < r && a[l] === b[r]) {
            l++;
            r--;
        }
        return isPalindrome(a, l, r) || isPalindrome(b, l, r);
    }
    return check(a, b) || check(b, a);
};
