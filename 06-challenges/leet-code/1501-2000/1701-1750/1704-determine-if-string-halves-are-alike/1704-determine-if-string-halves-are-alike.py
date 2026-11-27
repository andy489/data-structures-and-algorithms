# https://leetcode.com/problems/determine-if-string-halves-are-alike/

class Solution:
    def halvesAreAlike(self, s: str) -> bool:
        vowels = set('aeiouAEIOU')
        half = len(s) // 2
        return sum(c in vowels for c in s[:half]) == sum(c in vowels for c in s[half:])
