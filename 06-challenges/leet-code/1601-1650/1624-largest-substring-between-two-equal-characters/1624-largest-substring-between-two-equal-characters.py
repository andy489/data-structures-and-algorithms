# https://leetcode.com/problems/largest-substring-between-two-equal-characters/

class Solution:
    def maxLengthBetweenEqualCharacters(self, s: str) -> int:
        first = {}
        ans = -1
        for i, c in enumerate(s):
            if c not in first:
                first[c] = i
            else:
                ans = max(ans, i - first[c] - 1)
        return ans
