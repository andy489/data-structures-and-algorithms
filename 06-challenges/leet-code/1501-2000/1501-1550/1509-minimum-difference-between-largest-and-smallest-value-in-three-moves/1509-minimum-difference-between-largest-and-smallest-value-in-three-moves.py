# https://leetcode.com/problems/minimum-difference-between-largest-and-smallest-value-in-three-moves/

class Solution:
    def minDifference(self, nums) -> int:
        n = len(nums)
        if n <= 4:
            return 0
        nums.sort()
        return min(nums[n - 1 - (3 - i)] - nums[i] for i in range(4))
