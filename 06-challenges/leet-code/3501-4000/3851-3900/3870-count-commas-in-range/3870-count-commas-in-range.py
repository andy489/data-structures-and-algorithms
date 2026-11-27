# https://leetcode.com/problems/count-commas-in-range/

class Solution:
    def countCommas(self, n: int) -> int:
        return max(0, n - 999)
