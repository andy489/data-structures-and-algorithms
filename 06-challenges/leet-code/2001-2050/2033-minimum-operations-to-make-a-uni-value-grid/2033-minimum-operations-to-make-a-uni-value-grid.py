# https://leetcode.com/problems/minimum-operations-to-make-a-uni-value-grid/

class Solution:
    def minOperations(self, grid: list[list[int]], x: int) -> int:
        vals = sorted(v for row in grid for v in row)
        rem = vals[0] % x
        if any(v % x != rem for v in vals):
            return -1
        median = vals[len(vals) // 2]
        return sum(abs(v - median) // x for v in vals)
