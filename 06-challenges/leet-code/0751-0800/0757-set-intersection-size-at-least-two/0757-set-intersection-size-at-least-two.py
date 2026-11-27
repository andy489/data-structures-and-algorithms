# https://leetcode.com/problems/set-intersection-size-at-least-two/

class Solution:
    def intersectionSizeTwo(self, intervals: list[list[int]]) -> int:
        intervals.sort(key=lambda x: (x[1], -x[0]))
        count, p1, p2 = 0, -1, -1
        for s, e in intervals:
            if s > p1:
                count += 2
                p2, p1 = e - 1, e
            elif s > p2:
                count += 1
                p2, p1 = p1, e
        return count
