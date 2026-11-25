# https://leetcode.com/problems/making-a-large-island/

class Solution:
    def largestIsland(self, grid: list[list[int]]) -> int:
        n = len(grid)
        island_size = {}
        island_id = 2

        def dfs(r, c, id):
            if r < 0 or r >= n or c < 0 or c >= n or grid[r][c] != 1:
                return 0
            grid[r][c] = id
            return 1 + dfs(r+1,c,id) + dfs(r-1,c,id) + dfs(r,c+1,id) + dfs(r,c-1,id)

        max_size = 0
        for r in range(n):
            for c in range(n):
                if grid[r][c] == 1:
                    size = dfs(r, c, island_id)
                    island_size[island_id] = size
                    max_size = max(max_size, size)
                    island_id += 1

        for r in range(n):
            for c in range(n):
                if grid[r][c] == 0:
                    seen = set()
                    for dr, dc in ((0,1),(0,-1),(1,0),(-1,0)):
                        nr, nc = r+dr, c+dc
                        if 0 <= nr < n and 0 <= nc < n and grid[nr][nc] > 1:
                            seen.add(grid[nr][nc])
                    size = 1 + sum(island_size[i] for i in seen)
                    max_size = max(max_size, size)
        return max_size
