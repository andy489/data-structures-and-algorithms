# https://leetcode.com/problems/minimum-number-of-days-to-disconnect-island/

class Solution:
    def minDays(self, grid: list[list[int]]) -> int:
        m, n = len(grid), len(grid[0])

        def count_islands() -> int:
            visited = [[False] * n for _ in range(m)]
            count = 0
            for i in range(m):
                for j in range(n):
                    if grid[i][j] == 1 and not visited[i][j]:
                        flood(visited, i, j)
                        count += 1
            return count

        def flood(vis, i, j) -> None:
            vis[i][j] = True
            for di, dj in [(0, 1), (0, -1), (1, 0), (-1, 0)]:
                ni, nj = i + di, j + dj
                if 0 <= ni < m and 0 <= nj < n and grid[ni][nj] == 1 and not vis[ni][nj]:
                    flood(vis, ni, nj)

        if count_islands() != 1:
            return 0

        land = [(i, j) for i in range(m) for j in range(n) if grid[i][j] == 1]
        if len(land) == 1:
            return 1

        # Try removing each land cell
        for i, j in land:
            grid[i][j] = 0
            if count_islands() != 1:
                grid[i][j] = 1
                return 1
            grid[i][j] = 1
        return 2
