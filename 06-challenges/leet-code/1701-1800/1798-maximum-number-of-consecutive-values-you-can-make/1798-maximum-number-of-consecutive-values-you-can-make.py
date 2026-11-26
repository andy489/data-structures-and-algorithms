# https://leetcode.com/problems/maximum-number-of-consecutive-values-you-can-make/

class Solution:
    def getMaximumConsecutive(self, coins: list[int]) -> int:
        coins.sort()
        reach = 0
        for c in coins:
            if c > reach + 1:
                break
            reach += c
        return reach + 1
