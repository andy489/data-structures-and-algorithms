# https://leetcode.com/problems/check-if-grid-can-be-cut-into-sections/

class Solution:
    def checkValidCuts(self, n: int, rectangles: list[list[int]]) -> bool:
        def has_enough_gaps(axis: int) -> bool:
            intervals = sorted((r[axis], r[axis + 2]) for r in rectangles)
            gaps = 0
            max_end = intervals[0][1]
            for start, end in intervals[1:]:
                if start >= max_end:
                    gaps += 1
                    if gaps >= 2:
                        return True
                max_end = max(max_end, end)
            return False

        return has_enough_gaps(1) or has_enough_gaps(0)
