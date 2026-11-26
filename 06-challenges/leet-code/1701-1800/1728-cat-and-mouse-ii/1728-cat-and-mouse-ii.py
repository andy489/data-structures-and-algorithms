# https://leetcode.com/problems/cat-and-mouse-ii/

class Solution:
    def canMouseWin(self, grid: list[str], catJump: int, mouseJump: int) -> bool:
        rows, cols = len(grid), len(grid[0])
        dirs = [(0, 1), (0, -1), (1, 0), (-1, 0)]
        mr = mc = cr = cc = fr = fc = 0
        for i in range(rows):
            for j in range(cols):
                if grid[i][j] == 'M':
                    mr, mc = i, j
                elif grid[i][j] == 'C':
                    cr, cc = i, j
                elif grid[i][j] == 'F':
                    fr, fc = i, j

        from functools import lru_cache

        @lru_cache(maxsize=None)
        def solve(mr, mc, cr, cc, turn):
            if turn == 128:
                return False
            if mr == cr and mc == cc:
                return False
            if mr == fr and mc == fc:
                return True
            if turn % 2 == 0:
                # Mouse's turn
                for dr, dc in dirs:
                    for jump in range(mouseJump + 1):
                        nr, nc = mr + dr * jump, mc + dc * jump
                        if nr < 0 or nr >= rows or nc < 0 or nc >= cols or grid[nr][nc] == '#':
                            break
                        if solve(nr, nc, cr, cc, turn + 1):
                            return True
                return False
            else:
                # Cat's turn
                for dr, dc in dirs:
                    for jump in range(catJump + 1):
                        nr, nc = cr + dr * jump, cc + dc * jump
                        if nr < 0 or nr >= rows or nc < 0 or nc >= cols or grid[nr][nc] == '#':
                            break
                        if not solve(mr, mc, nr, nc, turn + 1):
                            return False
                return True

        return solve(mr, mc, cr, cc, 0)
