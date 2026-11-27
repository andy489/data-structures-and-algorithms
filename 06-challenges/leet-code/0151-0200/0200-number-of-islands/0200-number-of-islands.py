# https://leetcode.com/problems/number-of-islands/

from collections import deque

DIRS = (-1, 0, 1, 0, -1)

# Solution: DFS with in-place marking — O(m·n) time, O(m·n) space
class Solution:
    def numIslands(self, grid: list[list[str]]) -> int:
        m, n = len(grid), len(grid[0])

        def dfs(r: int, c: int) -> None:
            if r < 0 or r >= m or c < 0 or c >= n or grid[r][c] != '1':
                return
            grid[r][c] = '0'
            for k in range(4):
                dfs(r + DIRS[k], c + DIRS[k + 1])

        count = 0
        for r in range(m):
            for c in range(n):
                if grid[r][c] == '1':
                    count += 1
                    dfs(r, c)

        return count

# Solution 2: BFS with in-place marking — O(m·n) time, O(min(m,n)) space
class Solution2:
    def numIslands(self, grid: list[list[str]]) -> int:
        m, n = len(grid), len(grid[0])
        count = 0

        for r in range(m):
            for c in range(n):
                if grid[r][c] == '1':
                    count += 1
                    grid[r][c] = '0'
                    queue = deque([(r, c)])

                    while queue:
                        cr, cc = queue.popleft()
                        for k in range(4):
                            nr, nc = cr + DIRS[k], cc + DIRS[k + 1]
                            if 0 <= nr < m and 0 <= nc < n and grid[nr][nc] == '1':
                                grid[nr][nc] = '0'
                                queue.append((nr, nc))

        return count
