# https://leetcode.com/problems/find-the-longest-valid-obstacle-course-at-each-position/
import bisect

class Solution:
    def longestObstacleCourseAtEachPosition(self, obstacles: list[int]) -> list[int]:
        tails = []
        ans = []
        for h in obstacles:
            pos = bisect.bisect_right(tails, h)
            if pos == len(tails):
                tails.append(h)
            else:
                tails[pos] = h
            ans.append(pos + 1)
        return ans
