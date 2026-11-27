# https://leetcode.com/problems/find-the-difference/

class Solution:
    def findTheDifference(self, s: str, t: str) -> str:
        xor = 0
        for c in s + t:
            xor ^= ord(c)
        return chr(xor)
