# https://leetcode.com/problems/shortest-palindrome/

class Solution:
    def shortestPalindrome(self, s: str) -> str:
        rev = s[::-1]
        t = s + '#' + rev
        fail = [0] * len(t)
        for i in range(1, len(t)):
            j = fail[i - 1]
            while j > 0 and t[i] != t[j]:
                j = fail[j - 1]
            if t[i] == t[j]:
                j += 1
            fail[i] = j
        k = fail[-1]
        return rev[:len(s) - k] + s
