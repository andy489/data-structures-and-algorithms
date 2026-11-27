# https://leetcode.com/problems/minimum-initial-energy-to-finish-tasks/

class Solution:
    def minimumEffort(self, tasks: list[list[int]]) -> int:
        tasks.sort(key=lambda t: t[1] - t[0])
        energy = 0
        for actual, minimum in tasks:
            energy = max(energy + actual, minimum)
        return energy
