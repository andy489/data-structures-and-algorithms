# https://leetcode.com/problems/rectangle-area-ii/

class Solution:
    def rectangleArea(self, rectangles: list[list[int]]) -> int:
        MOD = 10**9 + 7
        xs = sorted(set(x for r in rectangles for x in (r[0], r[2])))
        ans = 0
        for i in range(len(xs) - 1):
            x1, x2 = xs[i], xs[i + 1]
            intervals = sorted((r[1], r[3]) for r in rectangles if r[0] <= x1 and x2 <= r[2])
            covered = 0
            cur_start = cur_end = -1
            for y1, y2 in intervals:
                if y1 > cur_end:
                    covered += cur_end - cur_start
                    cur_start, cur_end = y1, y2
                else:
                    cur_end = max(cur_end, y2)
            covered += cur_end - cur_start
            ans = (ans + (x2 - x1) * covered) % MOD
        return ans
