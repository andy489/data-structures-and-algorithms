# https://leetcode.com/problems/last-day-where-you-can-still-cross/
from collections import deque

class Solution:
    def latestDayToCross(self, row: int, col: int, cells: list[list[int]]) -> int:
        def can_cross(day: int) -> bool:
            water = [[False] * col for _ in range(row)]
            for i in range(day):
                water[cells[i][0] - 1][cells[i][1] - 1] = True
            queue = deque()
            for c in range(col):
                if not water[0][c]:
                    queue.append((0, c))
                    water[0][c] = True
            while queue:
                r, c = queue.popleft()
                if r == row - 1:
                    return True
                for dr, dc in [(1,0),(-1,0),(0,1),(0,-1)]:
                    nr, nc = r + dr, c + dc
                    if 0 <= nr < row and 0 <= nc < col and not water[nr][nc]:
                        water[nr][nc] = True
                        queue.append((nr, nc))
            return False

        lo, hi = 1, len(cells)
        while lo < hi:
            mid = (lo + hi + 1) // 2
            if can_cross(mid):
                lo = mid
            else:
                hi = mid - 1
        return lo
