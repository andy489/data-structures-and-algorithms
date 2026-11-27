# https://leetcode.com/problems/count-the-number-of-consistent-strings/

class Solution:
    def countConsistentStrings(self, allowed: str, words: list[str]) -> int:
        allowed_set = set(allowed)
        return sum(all(c in allowed_set for c in word) for word in words)
