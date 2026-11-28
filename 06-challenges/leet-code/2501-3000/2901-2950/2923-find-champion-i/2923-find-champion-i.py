# https://leetcode.com/problems/find-champion-i/

class Solution:
    def findChampion(self, grid: list[list[int]]) -> int:
        n = len(grid)
        for i in range(n):
            if sum(grid[i]) == n - 1:
                return i
        return -1
