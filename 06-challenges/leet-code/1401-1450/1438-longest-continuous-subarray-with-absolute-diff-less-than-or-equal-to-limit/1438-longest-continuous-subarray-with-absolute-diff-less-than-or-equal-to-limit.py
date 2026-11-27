# https://leetcode.com/problems/longest-continuous-subarray-with-absolute-diff-less-than-or-equal-to-limit/

class Solution:
    def longestSubarray(self, nums: list[int], limit: int) -> int:
        from collections import deque
        max_dq, min_dq = deque(), deque()
        left = ans = 0
        for right, v in enumerate(nums):
            while max_dq and nums[max_dq[-1]] <= v: max_dq.pop()
            while min_dq and nums[min_dq[-1]] >= v: min_dq.pop()
            max_dq.append(right); min_dq.append(right)
            while nums[max_dq[0]] - nums[min_dq[0]] > limit:
                left += 1
                if max_dq[0] < left: max_dq.popleft()
                if min_dq[0] < left: min_dq.popleft()
            ans = max(ans, right - left + 1)
        return ans
