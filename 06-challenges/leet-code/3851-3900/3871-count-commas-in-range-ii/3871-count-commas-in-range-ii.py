# https://leetcode.com/problems/count-commas-in-range-ii/

class Solution:
    def countCommas(self, n: int) -> int:
        result = 0
        threshold = 1000
        while threshold <= n:
            result += n - threshold + 1
            threshold *= 1000
        return result
