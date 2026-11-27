# https://leetcode.com/problems/shortest-path-in-a-grid-with-obstacles-elimination/

from collections import deque
class Solution:
    def shortestPath(self, grid: list[list[int]], k: int) -> int:
        m, n = len(grid), len(grid[0])
        if k >= m+n-2: return m+n-2
        visited = [[[False]*(k+1) for _ in range(n)] for _ in range(m)]
        q = deque([(0,0,k,0)])
        visited[0][0][k] = True
        while q:
            r, c, rem, steps = q.popleft()
            for dr, dc in [(-1,0),(1,0),(0,-1),(0,1)]:
                nr, nc = r+dr, c+dc
                if not(0<=nr<m and 0<=nc<n): continue
                nrem = rem - grid[nr][nc]
                if nrem < 0 or visited[nr][nc][nrem]: continue
                if nr==m-1 and nc==n-1: return steps+1
                visited[nr][nc][nrem] = True
                q.append((nr,nc,nrem,steps+1))
        return -1
