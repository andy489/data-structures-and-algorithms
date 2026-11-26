# https://leetcode.com/problems/shortest-unsorted-continuous-subarray/
class Solution:
    def findUnsortedSubarray(self, nums: List[int]) -> int:
        n = len(nums)
        left, right = -1, -1
        run_max = float('-inf')
        run_min = float('inf')
        for i in range(n):
            if nums[i] < run_max:
                right = i
            run_max = max(run_max, nums[i])
        if right == -1:
            return 0
        for i in range(n - 1, -1, -1):
            if nums[i] > run_min:
                left = i
            run_min = min(run_min, nums[i])
        return right - left + 1
