# https://leetcode.com/problems/count-vowel-strings-in-ranges/

# Solution: Prefix Sum — O(n + q) time, O(n) space
class Solution:
    def vowelStrings(self, words: list[str], queries: list[list[int]]) -> list[int]:
        vowels = set('aeiou')
        prefix = [0] * (len(words) + 1)
        for i, w in enumerate(words):
            prefix[i + 1] = prefix[i] + (1 if w[0] in vowels and w[-1] in vowels else 0)
        return [prefix[r + 1] - prefix[l] for l, r in queries]
