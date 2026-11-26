# https://leetcode.com/problems/count-number-of-maximum-bitwise-or-subsets/

class Solution:
    def countMaxOrSubsets(self, nums: list[int]) -> int:
        max_or = 0
        for x in nums:
            max_or |= x
        count = 0
        for mask in range(1, 1 << len(nums)):
            or_val = 0
            for i, x in enumerate(nums):
                if mask >> i & 1:
                    or_val |= x
            if or_val == max_or:
                count += 1
        return count
