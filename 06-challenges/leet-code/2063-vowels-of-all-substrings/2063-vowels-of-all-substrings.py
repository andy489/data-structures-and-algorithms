# https://leetcode.com/problems/vowels-of-all-substrings/

class Solution:
    def countVowels(self, word: str) -> int:
        n = len(word)
        vowels = set('aeiou')
        return sum((i + 1) * (n - i) for i, c in enumerate(word) if c in vowels)
