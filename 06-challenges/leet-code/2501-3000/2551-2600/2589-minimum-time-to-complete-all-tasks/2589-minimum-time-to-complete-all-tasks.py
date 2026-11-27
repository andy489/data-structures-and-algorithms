# https://leetcode.com/problems/minimum-time-to-complete-all-tasks/
class Solution:
    def findMinimumTime(self, tasks: list[list[int]]) -> int:
        tasks.sort(key=lambda t: t[1])
        running = [False] * 2001
        total = 0
        for start, end, dur in tasks:
            for t in range(start, end + 1):
                if running[t]:
                    dur -= 1
            t = end
            while t >= start and dur > 0:
                if not running[t]:
                    running[t] = True
                    dur -= 1
                    total += 1
                t -= 1
        return total
