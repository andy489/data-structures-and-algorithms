# https://leetcode.com/problems/check-if-there-is-a-valid-path-in-a-grid/

from collections import deque

class Solution:
    def hasValidPath(self, grid: list[list[int]]) -> bool:
        # directions: 0=up,1=down,2=left,3=right; opposite = {0:1,1:0,2:3,3:2}
        connects = {
            1: {2,3}, 2: {0,1}, 3: {1,2}, 4: {1,3}, 5: {0,3}, 6: {0,2}
        }
        dirs = [(-1,0,0),(1,0,1),(0,-1,2),(0,1,3)]
        opp = {0:1,1:0,2:3,3:2}
        m, n = len(grid), len(grid[0])
        visited = [[False]*n for _ in range(m)]
        visited[0][0] = True
        q = deque([(0,0)])
        while q:
            r, c = q.popleft()
            if r==m-1 and c==n-1:
                return True
            for dr,dc,d in dirs:
                nr,nc = r+dr, c+dc
                if 0<=nr<m and 0<=nc<n and not visited[nr][nc]:
                    if d in connects[grid[r][c]] and opp[d] in connects[grid[nr][nc]]:
                        visited[nr][nc] = True
                        q.append((nr,nc))
        return False
