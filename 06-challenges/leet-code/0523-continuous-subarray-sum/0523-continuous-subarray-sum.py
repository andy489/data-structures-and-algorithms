# https://leetcode.com/problems/continuous-subarray-sum/

class Solution:
    def checkSubarraySum(self, nums: list[int], k: int) -> bool:
        remainder_first_seen = {0: -1}
        prefix_sum = 0
        for i, num in enumerate(nums):
            prefix_sum = (prefix_sum + num) % k
            if prefix_sum in remainder_first_seen:
                if i - remainder_first_seen[prefix_sum] >= 2:
                    return True
            else:
                remainder_first_seen[prefix_sum] = i
        return False
