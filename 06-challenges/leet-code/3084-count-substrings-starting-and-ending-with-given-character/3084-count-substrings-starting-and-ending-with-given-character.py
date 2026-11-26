# https://leetcode.com/problems/count-substrings-starting-and-ending-with-given-character/

class Solution:
    def countSubstrings(self, s: str, c: str) -> int:
        k = s.count(c)
        return k * (k + 1) // 2
