# https://leetcode.com/problems/bricks-falling-when-hit/

class Solution:
    def hitBricks(self, grid: list[list[int]], hits: list[list[int]]) -> list[int]:
        m, n = len(grid), len(grid[0])
        copy = [row[:] for row in grid]
        for r, c in hits:
            copy[r][c] = 0

        parent = list(range(m * n + 1))
        size = [1] * (m * n + 1)
        roof = m * n

        def find(x):
            while parent[x] != x:
                parent[x] = parent[parent[x]]
                x = parent[x]
            return x

        def union(x, y):
            px, py = find(x), find(y)
            if px == py:
                return
            if size[px] < size[py]:
                px, py = py, px
            parent[py] = px
            size[px] += size[py]

        for r in range(m):
            for c in range(n):
                if copy[r][c] == 1:
                    if r == 0:
                        union(r * n + c, roof)
                    if r > 0 and copy[r - 1][c] == 1:
                        union(r * n + c, (r - 1) * n + c)
                    if c > 0 and copy[r][c - 1] == 1:
                        union(r * n + c, r * n + c - 1)

        result = [0] * len(hits)
        for i in range(len(hits) - 1, -1, -1):
            r, c = hits[i]
            if grid[r][c] == 0:
                continue
            prev_roof = size[find(roof)]
            copy[r][c] = 1
            if r == 0:
                union(r * n + c, roof)
            for dr, dc in ((0, 1), (0, -1), (1, 0), (-1, 0)):
                nr, nc = r + dr, c + dc
                if 0 <= nr < m and 0 <= nc < n and copy[nr][nc] == 1:
                    union(r * n + c, nr * n + nc)
            new_roof = size[find(roof)]
            result[i] = max(0, new_roof - prev_roof - 1)
        return result
