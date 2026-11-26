# https://leetcode.com/problems/two-city-scheduling/

class Solution:
    def twoCitySchedCost(self, costs: list[list[int]]) -> int:
        costs.sort(key=lambda c: c[1] - c[0])
        n = len(costs) // 2
        return sum(c[1] for c in costs[:n]) + sum(c[0] for c in costs[n:])
