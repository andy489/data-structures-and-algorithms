# https://leetcode.com/problems/maximum-number-of-tasks-you-can-assign/

class Solution:
    def maxTaskAssign(self, tasks: list[int], workers: list[int], pills: int, strength: int) -> int:
        from sortedcontainers import SortedList
        tasks.sort()
        workers.sort()
        def can_assign(k):
            sl = SortedList(workers[-k:])
            p = pills
            for i in range(k - 1, -1, -1):
                t = tasks[i]
                idx = sl.bisect_left(t)
                if idx < len(sl):
                    sl.pop(idx)
                else:
                    if p == 0:
                        return False
                    p -= 1
                    idx = sl.bisect_left(t - strength)
                    if idx >= len(sl):
                        return False
                    sl.pop(idx)
            return True
        lo, hi = 0, min(len(tasks), len(workers))
        while lo < hi:
            mid = (lo + hi + 1) // 2
            if can_assign(mid):
                lo = mid
            else:
                hi = mid - 1
        return lo
