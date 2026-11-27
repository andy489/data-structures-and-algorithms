# https://leetcode.com/problems/check-balanced-string/

# Solution: Single Pass Sum — O(n) time, O(1) space
class Solution:
    def isBalanced(self, num: str) -> bool:
        diff = 0
        for i, ch in enumerate(num):
            d = int(ch)
            if i % 2 == 0:
                diff += d
            else:
                diff -= d
        return diff == 0
