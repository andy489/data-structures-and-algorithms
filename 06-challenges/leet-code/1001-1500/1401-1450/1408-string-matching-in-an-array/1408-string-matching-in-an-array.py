# https://leetcode.com/problems/string-matching-in-an-array/

class Solution:
    def stringMatching(self, words: list[str]) -> list[str]:
        return [w for w in words if any(w in other for other in words if w != other)]
