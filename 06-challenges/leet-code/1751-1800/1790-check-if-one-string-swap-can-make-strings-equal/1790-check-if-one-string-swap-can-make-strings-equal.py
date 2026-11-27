# https://leetcode.com/problems/check-if-one-string-swap-can-make-strings-equal/

class Solution:
    def areAlmostEqual(self, s1: str, s2: str) -> bool:
        diffs = [(a, b) for a, b in zip(s1, s2) if a != b]
        if len(diffs) == 0:
            return True
        if len(diffs) == 2:
            return diffs[0] == diffs[1][::-1]
        return False
