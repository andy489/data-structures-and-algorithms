# https://leetcode.com/problems/maximum-spending-after-buying-items/

class Solution:
    def maxSpending(self, values: list[list[int]]) -> int:
        all_vals = sorted(v for row in values for v in row)
        return sum(v * (i + 1) for i, v in enumerate(all_vals))
