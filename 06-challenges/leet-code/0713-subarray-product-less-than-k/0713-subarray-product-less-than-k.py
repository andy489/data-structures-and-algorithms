# https://leetcode.com/problems/subarray-product-less-than-k/

class Solution:
    def numSubarrayProductLessThanK(self, nums: List[int], k: int) -> int:
        if k <= 1:
            return 0
        count, product, lo = 0, 1, 0
        for hi, num in enumerate(nums):
            product *= num
            while product >= k:
                product //= nums[lo]
                lo += 1
            count += hi - lo + 1
        return count
