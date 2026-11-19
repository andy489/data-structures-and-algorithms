# https://leetcode.com/problems/minimum-score-by-changing-two-elements/

# Solution: Sort + Four-Case Minimum — O(n log n) time, O(1) space
class Solution:
    def minimizeSum(self, nums: list[int]) -> int:
        nums.sort()
        n = len(nums)
        return min(nums[n - 3] - nums[0],
                   nums[n - 2] - nums[1],
                   nums[n - 1] - nums[2])
