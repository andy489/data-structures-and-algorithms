# https://leetcode.com/problems/maximum-number-of-distinct-elements-after-operations/

class Solution:
    def maxDistinctElements(self, nums: list[int], k: int) -> int:
        nums.sort()
        count = 0
        prev = float('-inf')
        for x in nums:
            candidate = max(x - k, prev + 1)
            if candidate <= x + k:
                count += 1
                prev = candidate
        return count
