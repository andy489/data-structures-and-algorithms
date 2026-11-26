# https://leetcode.com/problems/detect-cycles-in-2d-grid/

class Solution:
    def containsCycle(self, grid: list[list[str]]) -> bool:
        m, n = len(grid), len(grid[0])
        parent = list(range(m * n))
        rank = [0] * (m * n)

        def find(x: int) -> int:
            while parent[x] != x:
                parent[x] = parent[parent[x]]
                x = parent[x]
            return x

        def union(a: int, b: int) -> bool:
            ra, rb = find(a), find(b)
            if ra == rb:
                return False
            if rank[ra] < rank[rb]:
                parent[ra] = rb
            elif rank[ra] > rank[rb]:
                parent[rb] = ra
            else:
                parent[rb] = ra
                rank[ra] += 1
            return True

        for i in range(m):
            for j in range(n):
                for di, dj in [(0, 1), (1, 0)]:
                    ni, nj = i + di, j + dj
                    if ni < m and nj < n and grid[ni][nj] == grid[i][j]:
                        if not union(i * n + j, ni * n + nj):
                            return True
        return False
