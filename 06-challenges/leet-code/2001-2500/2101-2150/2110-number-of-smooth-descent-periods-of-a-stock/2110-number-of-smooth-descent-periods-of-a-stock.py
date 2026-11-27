# https://leetcode.com/problems/number-of-smooth-descent-periods-of-a-stock/

# Solution: Running Count — O(n) time, O(1) space
class Solution:
    def getDescentPeriods(self, prices: list[int]) -> int:
        result = 0
        run = 1

        for i in range(len(prices)):
            if i > 0 and prices[i] == prices[i - 1] - 1:
                run += 1
            else:
                run = 1
            result += run

        return result
