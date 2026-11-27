# https://leetcode.com/problems/sort-vowels-by-frequency/
from collections import Counter


class Solution:
    def sortVowelsByFrequency(self, s: str) -> str:
        vowels = set('aeiou')
        freq = Counter(c for c in s if c in vowels)
        first_occ = {}
        for i, c in enumerate(s):
            if c in vowels and c not in first_occ:
                first_occ[c] = i
        vowel_positions = [i for i, c in enumerate(s) if c in vowels]
        vowel_chars = [c for c in s if c in vowels]
        vowel_chars.sort(key=lambda c: (-freq[c], first_occ[c]))
        res = list(s)
        for idx, pos in enumerate(vowel_positions):
            res[pos] = vowel_chars[idx]
        return ''.join(res)
