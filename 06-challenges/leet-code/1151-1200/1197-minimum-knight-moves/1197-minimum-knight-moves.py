# https://leetcode.com/problems/minimum-knight-moves/

from collections import deque
class Solution:
    def minKnightMoves(self, x: int, y: int) -> int:
        x, y = abs(x), abs(y)
        dirs = [(1,2),(1,-2),(-1,2),(-1,-2),(2,1),(2,-1),(-2,1),(-2,-1)]
        q = deque([(0, 0, 0)])
        visited = {(0, 0)}
        while q:
            cx, cy, dist = q.popleft()
            if cx == x and cy == y:
                return dist
            for dx, dy in dirs:
                nx, ny = cx+dx, cy+dy
                if nx >= -2 and ny >= -2 and (nx, ny) not in visited:
                    visited.add((nx, ny))
                    q.append((nx, ny, dist+1))
        return -1
