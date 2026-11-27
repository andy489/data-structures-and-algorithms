# https://leetcode.com/problems/count-the-number-of-incremovable-subarrays-i/
class Solution:
    def incremovableSubarrayCount(self, nums: list[int]) -> int:
        n = len(nums)
        count = 0
        for i in range(n):
            for j in range(i, n):
                remaining = nums[:i] + nums[j + 1:]
                if all(remaining[k] < remaining[k + 1] for k in range(len(remaining) - 1)):
                    count += 1
        return count
