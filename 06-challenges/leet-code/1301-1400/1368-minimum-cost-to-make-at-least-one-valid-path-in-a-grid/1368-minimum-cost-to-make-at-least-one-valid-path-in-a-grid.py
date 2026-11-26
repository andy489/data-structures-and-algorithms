# https://leetcode.com/problems/minimum-cost-to-make-at-least-one-valid-path-in-a-grid/

from collections import deque

class Solution:
    def minCost(self, grid: list[list[int]]) -> int:
        m, n = len(grid), len(grid[0])
        dirs = [(0,1),(0,-1),(1,0),(-1,0)]
        dist = [[float('inf')]*n for _ in range(m)]
        dist[0][0] = 0
        dq = deque([(0, 0)])
        while dq:
            r, c = dq.popleft()
            for d, (dr, dc) in enumerate(dirs):
                nr, nc = r+dr, c+dc
                if 0<=nr<m and 0<=nc<n:
                    cost = 0 if grid[r][c]-1==d else 1
                    if dist[r][c]+cost < dist[nr][nc]:
                        dist[nr][nc] = dist[r][c]+cost
                        if cost==0: dq.appendleft((nr,nc))
                        else: dq.append((nr,nc))
        return dist[m-1][n-1]
