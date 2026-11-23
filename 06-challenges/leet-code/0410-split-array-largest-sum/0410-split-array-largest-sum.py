# https://leetcode.com/problems/split-array-largest-sum/

class Solution:
    def splitArray(self, nums: list[int], k: int) -> int:
        def can_split(max_sum):
            subarrays, current = 1, 0
            for num in nums:
                if current + num > max_sum:
                    subarrays += 1
                    current = num
                    if subarrays > k:
                        return False
                else:
                    current += num
            return True

        lo, hi = max(nums), sum(nums)
        while lo < hi:
            mid = (lo + hi) // 2
            if can_split(mid):
                hi = mid
            else:
                lo = mid + 1
        return lo
