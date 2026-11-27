# https://leetcode.com/problems/count-binary-substrings/

class Solution:
    def countBinarySubstrings(self, s: str) -> int:
        result = prev = 0
        curr = 1
        for i in range(1, len(s)):
            if s[i] == s[i - 1]:
                curr += 1
            else:
                result += min(prev, curr)
                prev, curr = curr, 1
        return result + min(prev, curr)
