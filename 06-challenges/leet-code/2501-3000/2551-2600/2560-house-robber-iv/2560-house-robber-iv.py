# https://leetcode.com/problems/house-robber-iv/

# Solution: Binary Search on Answer — O(n log(max)) time, O(1) space
class Solution:
    def minCapability(self, nums: list[int], k: int) -> int:
        def can_rob(cap: int) -> bool:
            count = 0
            i = 0
            while i < len(nums):
                if nums[i] <= cap:
                    count += 1
                    i += 2  # skip adjacent
                else:
                    i += 1
            return count >= k

        lo, hi = min(nums), max(nums)
        while lo < hi:
            mid = (lo + hi) // 2
            if can_rob(mid):
                hi = mid
            else:
                lo = mid + 1
        return lo
