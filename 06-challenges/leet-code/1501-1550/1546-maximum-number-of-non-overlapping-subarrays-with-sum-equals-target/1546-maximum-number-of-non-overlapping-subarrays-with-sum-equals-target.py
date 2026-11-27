# https://leetcode.com/problems/maximum-number-of-non-overlapping-subarrays-with-sum-equals-target/

class Solution:
    def maxNonOverlapping(self, nums: list[int], target: int) -> int:
        seen = {0}
        prefix = 0
        count = 0
        for num in nums:
            prefix += num
            if prefix - target in seen:
                count += 1
                seen = {0}
                prefix = 0
            else:
                seen.add(prefix)
        return count
