# https://leetcode.com/problems/water-bottles-ii/

class Solution:
    def maxBottlesDrunk(self, numBottles: int, numExchange: int) -> int:
        total = empties = numBottles
        while empties >= numExchange:
            empties -= numExchange
            empties += 1
            total += 1
            numExchange += 1
        return total
