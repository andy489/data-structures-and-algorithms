# https://leetcode.com/problems/max-consecutive-ones-iii/

class Solution:
    def longestOnes(self, nums: list[int], k: int) -> int:
        left = zeros = ans = 0
        for right, v in enumerate(nums):
            if v == 0:
                zeros += 1
            while zeros > k:
                if nums[left] == 0:
                    zeros -= 1
                left += 1
            ans = max(ans, right - left + 1)
        return ans
