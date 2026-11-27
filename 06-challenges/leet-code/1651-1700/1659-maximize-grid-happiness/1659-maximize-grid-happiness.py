# https://leetcode.com/problems/maximize-grid-happiness/

from functools import lru_cache

class Solution:
    def getMaxGridHappiness(self, m: int, n: int, introvertsCount: int, extrovertsCount: int) -> int:
        INTRO_BASE, EXTRO_BASE = 120, 40
        INTRO_COST, EXTRO_GAIN = -30, 20

        def interaction(t1: int, t2: int) -> int:
            if t1 == 0 or t2 == 0:
                return 0
            my = INTRO_COST if t1 == 1 else EXTRO_GAIN
            nb = INTRO_COST if t2 == 1 else EXTRO_GAIN
            return my + nb

        @lru_cache(maxsize=None)
        def solve(pos: int, intro: int, extro: int, prev_row: tuple) -> int:
            if pos == m * n or (intro == 0 and extro == 0):
                return 0
            col = pos % n
            top = prev_row[col]
            cur_row = list(prev_row)
            left = cur_row[col - 1] if col > 0 else 0

            best = solve(pos + 1, intro, extro, tuple(cur_row))

            if intro > 0:
                delta = INTRO_BASE + interaction(1, top) + interaction(1, left)
                cur_row[col] = 1
                best = max(best, delta + solve(pos + 1, intro - 1, extro, tuple(cur_row)))
                cur_row[col] = 0

            if extro > 0:
                delta = EXTRO_BASE + interaction(2, top) + interaction(2, left)
                cur_row[col] = 2
                best = max(best, delta + solve(pos + 1, intro, extro - 1, tuple(cur_row)))
                cur_row[col] = 0

            return best

        return solve(0, introvertsCount, extrovertsCount, tuple([0] * n))
