# https://leetcode.com/problems/prison-cells-after-n-days/

class Solution:
    def prisonAfterNDays(self, cells: list[int], n: int) -> list[int]:
        def next_day(c):
            return [0] + [1 if c[i-1] == c[i+1] else 0 for i in range(1, 7)] + [0]

        seen = {}
        cells = list(cells)
        for day in range(n):
            key = tuple(cells)
            if key in seen:
                cycle = day - seen[key]
                remaining = (n - day) % cycle
                for _ in range(remaining):
                    cells = next_day(cells)
                return cells
            seen[key] = day
            cells = next_day(cells)
        return cells
