# https://leetcode.com/problems/count-non-decreasing-subarrays-after-k-operations/

from collections import deque

class Solution:
    def countNonDecreasingSubarrays(self, nums: list[int], k: int) -> int:
        n = len(nums)
        ans = 0
        cost = 0
        dq = deque()
        l = 0
        for r in range(n):
            while dq and nums[dq[-1]] < nums[r]:
                idx = dq.pop()
                prev_idx = dq[-1] if dq else l - 1
                cost += (nums[r] - nums[idx]) * (idx - prev_idx)
            dq.append(r)
            while cost > k:
                if dq[0] == l:
                    dq.popleft()
                l += 1
                while dq and dq[0] < l:
                    dq.popleft()
                cost = self._compute_cost(nums, l, r)
            ans += r - l + 1
        return ans

    def _compute_cost(self, nums: list[int], l: int, r: int) -> int:
        cost = 0
        max_val = nums[l]
        for i in range(l + 1, r + 1):
            if nums[i] < max_val:
                cost += max_val - nums[i]
            else:
                max_val = nums[i]
        return cost
