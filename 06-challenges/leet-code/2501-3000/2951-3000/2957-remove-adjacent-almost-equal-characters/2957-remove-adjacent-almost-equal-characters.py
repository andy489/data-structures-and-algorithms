# https://leetcode.com/problems/remove-adjacent-almost-equal-characters/
class Solution:
    def removeAlmostEqualCharacters(self, word: str) -> int:
        ops = 0
        i = 1
        while i < len(word):
            if abs(ord(word[i]) - ord(word[i - 1])) <= 1:
                ops += 1
                i += 2
            else:
                i += 1
        return ops
