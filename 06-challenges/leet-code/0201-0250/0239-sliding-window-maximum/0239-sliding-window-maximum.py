# https://leetcode.com/problems/sliding-window-maximum/

from collections import deque

class Solution:
    def maxSlidingWindow(self, nums: list[int], k: int) -> list[int]:
        dq: deque[int] = deque()
        result: list[int] = []

        for i, v in enumerate(nums):
            while dq and nums[dq[-1]] <= v:
                dq.pop()
            dq.append(i)
            if dq[0] < i - k + 1:
                dq.popleft()
            if i >= k - 1:
                result.append(nums[dq[0]])
        return result
