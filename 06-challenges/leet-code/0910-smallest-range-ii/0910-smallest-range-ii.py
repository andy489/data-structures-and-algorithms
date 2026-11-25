# https://leetcode.com/problems/smallest-range-ii/

class Solution:
    def smallestRangeII(self, nums: list, k: int) -> int:
        nums.sort()
        n = len(nums)
        result = nums[-1] - nums[0]
        for i in range(n - 1):
            hi = max(nums[i] + k, nums[-1] - k)
            lo = min(nums[0] + k, nums[i + 1] - k)
            result = min(result, hi - lo)
        return result
