# https://leetcode.com/problems/reducing-dishes/

class Solution:
    def maxSatisfaction(self, satisfaction: list[int]) -> int:
        satisfaction.sort(reverse=True)
        total = suffix = 0
        for s in satisfaction:
            if suffix + s <= 0:
                break
            suffix += s
            total += suffix
        return total
