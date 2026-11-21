# https://leetcode.com/problems/gas-station/

# Solution: Greedy Single Pass — O(n) time, O(1) space
class Solution:
    def canCompleteCircuit(self, gas: list[int], cost: list[int]) -> int:
        total = tank = start = 0
        for i, (g, c) in enumerate(zip(gas, cost)):
            diff = g - c
            total += diff
            tank += diff
            if tank < 0:
                start = i + 1
                tank = 0
        return start if total >= 0 else -1
