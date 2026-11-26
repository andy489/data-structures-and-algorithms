# https://leetcode.com/problems/maximum-number-of-vowels-in-a-substring-of-given-length/

class Solution:
    def maxVowels(self, s: str, k: int) -> int:
        vowels = set('aeiou')
        cur = sum(c in vowels for c in s[:k])
        best = cur
        for i in range(k, len(s)):
            cur += (s[i] in vowels) - (s[i-k] in vowels)
            best = max(best, cur)
        return best
