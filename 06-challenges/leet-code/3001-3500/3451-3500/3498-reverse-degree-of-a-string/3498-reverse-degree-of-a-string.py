# https://leetcode.com/problems/reverse-degree-of-a-string/

class Solution:
    def reverseDegree(self, s: str) -> int:
        result = 0
        for i, c in enumerate(s):
            reverse_val = 26 - (ord(c) - ord('a'))
            result += (i + 1) * reverse_val
        return result
