# https://leetcode.com/problems/consecutive-characters/

class Solution:
    def maxPower(self, s: str) -> int:
        max_p = cur = 1
        for i in range(1, len(s)):
            if s[i] == s[i-1]:
                cur += 1
                max_p = max(max_p, cur)
            else:
                cur = 1
        return max_p
