# https://leetcode.com/problems/minimum-moves-to-reach-target-with-rotations/

from collections import deque
class Solution:
    def minimumMoves(self, grid: list[list[int]]) -> int:
        n = len(grid)
        visited = set()
        visited.add((0, 0, 0))
        q = deque([(0, 0, 0, 0)])
        while q:
            r, c, d, steps = q.popleft()
            if r == n-1 and c == n-2 and d == 0: return steps
            nxt = []
            if d == 0:
                if c+2<n and grid[r][c+2]==0: nxt.append((r,c+1,0))
                if r+1<n and grid[r+1][c]==0 and grid[r+1][c+1]==0: nxt.append((r+1,c,0)); nxt.append((r,c,1))
            else:
                if r+2<n and grid[r+2][c]==0: nxt.append((r+1,c,1))
                if c+1<n and grid[r][c+1]==0 and grid[r+1][c+1]==0: nxt.append((r,c+1,1)); nxt.append((r,c,0))
            for state in nxt:
                if state not in visited: visited.add(state); q.append(state+(steps+1,))
        return -1
