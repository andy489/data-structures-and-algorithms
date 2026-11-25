# https://leetcode.com/problems/number-of-subarrays-with-bounded-maximum/

class Solution:
    def numSubarrayBoundedMax(self, nums: list[int], left: int, right: int) -> int:
        def count(bound):
            result = curr = 0
            for num in nums:
                curr = curr + 1 if num <= bound else 0
                result += curr
            return result
        return count(right) - count(left - 1)
