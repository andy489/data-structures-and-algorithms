# https://leetcode.com/problems/maximum-frequency-of-an-element-after-performing-operations-ii/

# Solution: Sort + Binary Search — O(n log n) time, O(1) space
import bisect

class Solution:
    def maxFrequency(self, nums: list[int], k: int, numOperations: int) -> int:
        nums.sort()
        n = len(nums)
        ans = 0

        prev = None
        for v in nums:
            if v == prev:
                continue
            prev = v
            lo = bisect.bisect_left(nums, v - k)
            hi = bisect.bisect_right(nums, v + k)
            in_range = hi - lo
            exact = bisect.bisect_right(nums, v) - bisect.bisect_left(nums, v)
            need_ops = in_range - exact
            ans = max(ans, exact + min(need_ops, numOperations))
        return ans
