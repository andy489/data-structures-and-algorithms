# https://leetcode.com/problems/water-bottles/

class Solution:
    def numWaterBottles(self, numBottles: int, numExchange: int) -> int:
        drunk = 0
        empty = 0
        while numBottles > 0:
            drunk += numBottles
            empty += numBottles
            numBottles, empty = divmod(empty, numExchange)
        return drunk
