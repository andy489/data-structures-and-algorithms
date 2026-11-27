# https://leetcode.com/problems/ways-to-make-a-fair-array/

class Solution:
    def waysToMakeFair(self, nums: list[int]) -> int:
        total_even = sum(nums[i] for i in range(0, len(nums), 2))
        total_odd  = sum(nums[i] for i in range(1, len(nums), 2))
        prefix_even = prefix_odd = count = 0
        for i, v in enumerate(nums):
            rem_even = total_even - prefix_even - (v if i % 2 == 0 else 0)
            rem_odd  = total_odd  - prefix_odd  - (v if i % 2 == 1 else 0)
            if prefix_even + rem_odd == prefix_odd + rem_even:
                count += 1
            if i % 2 == 0:
                prefix_even += v
            else:
                prefix_odd += v
        return count
