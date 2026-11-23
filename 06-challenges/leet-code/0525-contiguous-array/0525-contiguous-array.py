# https://leetcode.com/problems/contiguous-array/

class Solution:
    def findMaxLength(self, nums: list[int]) -> int:
        first_occurrence = {0: -1}
        prefix_sum = 0
        max_len = 0
        for i, num in enumerate(nums):
            prefix_sum += 1 if num == 1 else -1
            if prefix_sum in first_occurrence:
                max_len = max(max_len, i - first_occurrence[prefix_sum])
            else:
                first_occurrence[prefix_sum] = i
        return max_len
