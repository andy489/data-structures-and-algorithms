# https://leetcode.com/problems/water-and-jug-problem/

from math import gcd

class Solution:
    def canMeasureWater(self, x: int, y: int, target: int) -> bool:
        if target > x + y:
            return False
        return target % gcd(x, y) == 0
