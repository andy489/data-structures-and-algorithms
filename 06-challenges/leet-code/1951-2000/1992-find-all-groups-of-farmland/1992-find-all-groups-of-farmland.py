# https://leetcode.com/problems/find-all-groups-of-farmland/
class Solution:
    def findFarmland(self, land: list[list[int]]) -> list[list[int]]:
        m, n = len(land), len(land[0])
        result = []
        for r in range(m):
            for c in range(n):
                if land[r][c] == 1:
                    r2, c2 = r, c
                    while r2 + 1 < m and land[r2 + 1][c] == 1:
                        r2 += 1
                    while c2 + 1 < n and land[r][c2 + 1] == 1:
                        c2 += 1
                    result.append([r, c, r2, c2])
                    for i in range(r, r2 + 1):
                        for j in range(c, c2 + 1):
                            land[i][j] = 0
        return result
