# https://leetcode.com/problems/minimum-swaps-to-arrange-a-binary-grid/

class Solution:
    def minSwaps(self, grid: list[list[int]]) -> int:
        n = len(grid)
        trailing = []
        for row in grid:
            z = 0
            for j in range(n - 1, -1, -1):
                if row[j] == 0:
                    z += 1
                else:
                    break
            trailing.append(z)
        swaps = 0
        for i in range(n):
            need = n - 1 - i
            found = -1
            for j in range(i, n):
                if trailing[j] >= need:
                    found = j
                    break
            if found == -1:
                return -1
            while found > i:
                trailing[found], trailing[found - 1] = trailing[found - 1], trailing[found]
                found -= 1
                swaps += 1
        return swaps
