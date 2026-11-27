# https://leetcode.com/problems/maximum-product-subarray/

# Solution 1: Track max and min — O(n) time, O(1) space
class Solution:
    def maxProduct(self, nums: list[int]) -> int:
        cur_max = cur_min = result = nums[0]
        for n in nums[1:]:
            candidates = (n, cur_max * n, cur_min * n)
            cur_max, cur_min = max(candidates), min(candidates)
            result = max(result, cur_max)
        return result


# Solution 2: Forward + backward pass — O(n) time, O(1) space
class Solution2:
    def maxProduct(self, nums: list[int]) -> int:
        result = float('-inf')
        prod = 1
        for n in nums:
            prod *= n
            result = max(result, prod)
            if prod == 0:
                prod = 1
        prod = 1
        for n in reversed(nums):
            prod *= n
            result = max(result, prod)
            if prod == 0:
                prod = 1
        return result
