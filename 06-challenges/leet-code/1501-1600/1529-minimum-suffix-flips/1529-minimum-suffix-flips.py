# https://leetcode.com/problems/minimum-suffix-flips/

class Solution:
    def minFlips(self, target: str) -> int:
        flips = 0
        current = '0'
        for c in target:
            if c != current:
                flips += 1
                current = c
        return flips
