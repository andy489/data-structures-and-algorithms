// https://leetcode.com/problems/find-first-palindromic-string-in-the-array/

// Solution: Two Pointers — O(n * m) time, O(1) space
var firstPalindrome = function(words) {
    for (const word of words) {
        let l = 0, r = word.length - 1;
        let palindrome = true;
        while (l < r) {
            if (word[l] !== word[r]) {
                palindrome = false;
                break;
            }
            l++;
            r--;
        }
        if (palindrome) return word;
    }
    return "";
};
