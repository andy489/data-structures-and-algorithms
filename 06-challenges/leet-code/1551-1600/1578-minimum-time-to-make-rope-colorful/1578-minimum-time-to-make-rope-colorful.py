# https://leetcode.com/problems/minimum-time-to-make-rope-colorful/

class Solution:
    def minCost(self, colors: str, neededTime: list[int]) -> int:
        total = 0
        i = 0
        n = len(colors)
        while i < n:
            j = i
            group_sum = 0
            group_max = 0
            while j < n and colors[j] == colors[i]:
                group_sum += neededTime[j]
                group_max = max(group_max, neededTime[j])
                j += 1
            total += group_sum - group_max
            i = j
        return total
