# https://leetcode.com/problems/number-of-ways-to-buy-pens-and-pencils/

class Solution:
    def waysToBuyPensPencils(self, total: int, cost1: int, cost2: int) -> int:
        ways = 0
        pens = 0
        while pens * cost1 <= total:
            ways += (total - pens * cost1) // cost2 + 1
            pens += 1
        return ways
