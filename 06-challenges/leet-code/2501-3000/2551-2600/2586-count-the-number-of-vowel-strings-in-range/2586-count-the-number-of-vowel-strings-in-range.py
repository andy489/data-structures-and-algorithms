# https://leetcode.com/problems/count-the-number-of-vowel-strings-in-range/
class Solution:
    def vowelStrings(self, words: list[str], left: int, right: int) -> int:
        vowels = set("aeiou")
        return sum(
            1 for w in words[left:right + 1]
            if w[0] in vowels and w[-1] in vowels
        )
