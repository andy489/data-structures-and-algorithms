# https://leetcode.com/problems/find-missing-and-repeated-values/
class Solution:
    def findMissingAndRepeatedValues(self, grid: list[list[int]]) -> list[int]:
        n = len(grid)
        total = n * n
        count = [0] * (total + 1)
        for row in grid:
            for val in row:
                count[val] += 1
        repeated = missing = -1
        for i in range(1, total + 1):
            if count[i] == 2:
                repeated = i
            elif count[i] == 0:
                missing = i
        return [repeated, missing]
