# https://leetcode.com/problems/contain-virus/

from collections import deque

class Solution:
    def containVirus(self, grid: list[list[int]]) -> int:
        m, n = len(grid), len(grid[0])
        dirs = [(0,1),(0,-1),(1,0),(-1,0)]
        total = 0
        while True:
            visited = [[False]*n for _ in range(m)]
            regions, threats, walls = [], [], []
            for i in range(m):
                for j in range(n):
                    if grid[i][j] == 1 and not visited[i][j]:
                        region, threat, wall = [], set(), [0]
                        q = deque([(i,j)])
                        visited[i][j] = True
                        while q:
                            r, c = q.popleft()
                            region.append((r,c))
                            for dr, dc in dirs:
                                nr, nc = r+dr, c+dc
                                if 0 <= nr < m and 0 <= nc < n:
                                    if grid[nr][nc] == 1 and not visited[nr][nc]:
                                        visited[nr][nc] = True
                                        q.append((nr,nc))
                                    elif grid[nr][nc] == 0:
                                        threat.add((nr,nc))
                                        wall[0] += 1
                        if threat:
                            regions.append(region); threats.append(threat); walls.append(wall[0])
            if not regions:
                break
            worst = max(range(len(threats)), key=lambda x: len(threats[x]))
            total += walls[worst]
            for r, c in regions[worst]:
                grid[r][c] = -1
            for i, region in enumerate(regions):
                if i != worst:
                    for r, c in region:
                        for dr, dc in dirs:
                            nr, nc = r+dr, c+dc
                            if 0 <= nr < m and 0 <= nc < n and grid[nr][nc] == 0:
                                grid[nr][nc] = 1
        return total
