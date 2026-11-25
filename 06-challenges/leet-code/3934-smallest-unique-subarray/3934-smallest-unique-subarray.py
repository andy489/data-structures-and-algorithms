# https://leetcode.com/problems/smallest-unique-subarray/

class Solution:
    def smallestUniqueSubarray(self, nums: list[int]) -> int:
        n = len(nums)
        prev = [-1] * n
        nxt = [n] * n
        last = {}
        for i, x in enumerate(nums):
            prev[i] = last.get(x, -1)
            last[x] = i
        last.clear()
        for i in range(n - 1, -1, -1):
            nxt[i] = last.get(nums[i], n)
            last[nums[i]] = i

        from collections import deque

        def check(k):
            max_dq, min_dq = deque(), deque()
            for r in range(n):
                while max_dq and prev[max_dq[-1]] <= prev[r]:
                    max_dq.pop()
                max_dq.append(r)
                while min_dq and nxt[min_dq[-1]] >= nxt[r]:
                    min_dq.pop()
                min_dq.append(r)
                if r >= k - 1:
                    l = r - k + 1
                    if max_dq[0] < l:
                        max_dq.popleft()
                    if min_dq[0] < l:
                        min_dq.popleft()
                    if prev[max_dq[0]] < l and nxt[min_dq[0]] > r:
                        return True
            return False

        lo, hi = 1, n
        while lo < hi:
            mid = (lo + hi) // 2
            if check(mid):
                hi = mid
            else:
                lo = mid + 1
        return lo
