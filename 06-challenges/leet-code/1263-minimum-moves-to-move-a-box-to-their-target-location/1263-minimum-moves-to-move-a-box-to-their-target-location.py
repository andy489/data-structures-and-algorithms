# https://leetcode.com/problems/minimum-moves-to-move-a-box-to-their-target-location/

import heapq
from collections import deque
class Solution:
    def minPushBox(self, grid: list[list[str]]) -> int:
        m, n = len(grid), len(grid[0])
        for i in range(m):
            for j in range(n):
                if grid[i][j]=='B': box=(i,j)
                if grid[i][j]=='S': player=(i,j)
        dirs = [(-1,0),(1,0),(0,-1),(0,1)]
        def can_reach(sr,sc,tr,tc,br,bc):
            if (sr,sc)==(tr,tc): return True
            vis={(sr,sc)}; q=deque([(sr,sc)])
            while q:
                r,c=q.popleft()
                for dr,dc in dirs:
                    nr,nc=r+dr,c+dc
                    if 0<=nr<m and 0<=nc<n and grid[nr][nc]!='#' and (nr,nc)!=(br,bc) and (nr,nc) not in vis:
                        if (nr,nc)==(tr,tc): return True
                        vis.add((nr,nc)); q.append((nr,nc))
            return False
        INF=float('inf')
        dist={(box[0],box[1],player[0],player[1]):0}
        pq=[(0,box[0],box[1],player[0],player[1])]
        while pq:
            cost,br,bc,pr,pc=heapq.heappop(pq)
            if grid[br][bc]=='T': return cost
            if cost>dist.get((br,bc,pr,pc),INF): continue
            for dr,dc in dirs:
                nbr,nbc=br+dr,bc+dc
                if not(0<=nbr<m and 0<=nbc<n) or grid[nbr][nbc]=='#': continue
                push_r,push_c=br-dr,bc-dc
                if not(0<=push_r<m and 0<=push_c<n) or grid[push_r][push_c]=='#': continue
                if can_reach(pr,pc,push_r,push_c,br,bc):
                    nd=cost+1
                    if nd<dist.get((nbr,nbc,br,bc),INF):
                        dist[(nbr,nbc,br,bc)]=nd; heapq.heappush(pq,(nd,nbr,nbc,br,bc))
        return -1
