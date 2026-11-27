# https://leetcode.com/problems/find-first-palindromic-string-in-the-array/

# Solution: Two Pointers — O(n * m) time, O(1) space
class Solution:
    def firstPalindrome(self, words: list[str]) -> str:
        for word in words:
            if word == word[::-1]:
                return word
        return ""
