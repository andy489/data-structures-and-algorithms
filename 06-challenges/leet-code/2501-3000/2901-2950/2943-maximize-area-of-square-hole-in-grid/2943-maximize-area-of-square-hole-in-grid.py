# https://leetcode.com/problems/maximize-area-of-square-hole-in-grid/

class Solution:
    def maximizeSquareHoleArea(self, n: int, m: int, hBars: list[int], vBars: list[int]) -> int:
        def max_consecutive(bars):
            bars.sort()
            max_run = run = 1
            for i in range(1, len(bars)):
                if bars[i] == bars[i - 1] + 1:
                    run += 1
                    max_run = max(max_run, run)
                else:
                    run = 1
            return max_run

        side = min(max_consecutive(hBars), max_consecutive(vBars)) + 1
        return side * side
