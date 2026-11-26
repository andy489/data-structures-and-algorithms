# https://leetcode.com/problems/grid-illumination/

class Solution:
    def gridIllumination(self, n: int, lamps: list[list[int]], queries: list[list[int]]) -> list[int]:
        from collections import defaultdict
        row, col, diag, anti = defaultdict(int), defaultdict(int), defaultdict(int), defaultdict(int)
        lit = set()
        for r, c in lamps:
            if (r, c) not in lit:
                lit.add((r, c))
                row[r] += 1
                col[c] += 1
                diag[r - c] += 1
                anti[r + c] += 1
        ans = []
        dirs = [(dr, dc) for dr in (-1, 0, 1) for dc in (-1, 0, 1)]
        for r, c in queries:
            if row[r] or col[c] or diag[r - c] or anti[r + c]:
                ans.append(1)
            else:
                ans.append(0)
            for dr, dc in dirs:
                nr, nc = r + dr, c + dc
                if (nr, nc) in lit:
                    lit.remove((nr, nc))
                    row[nr] -= 1
                    col[nc] -= 1
                    diag[nr - nc] -= 1
                    anti[nr + nc] -= 1
        return ans
