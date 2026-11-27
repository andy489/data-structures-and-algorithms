# https://leetcode.com/problems/adjacent-increasing-subarrays-detection-ii/

# Solution: Precompute Ending/Starting Run Lengths — O(n) time, O(n) space
class Solution:
    def maxIncreasingSubarrays(self, nums: list[int]) -> int:
        n = len(nums)
        # inc[i] = length of strictly increasing run ending at i
        inc = [1] * n
        for i in range(1, n):
            if nums[i] > nums[i - 1]:
                inc[i] = inc[i - 1] + 1
        # start_inc[i] = length of strictly increasing run starting at i
        start_inc = [1] * n
        for i in range(n - 2, -1, -1):
            if nums[i + 1] > nums[i]:
                start_inc[i] = start_inc[i + 1] + 1
        ans = 0
        for m in range(1, n):
            ans = max(ans, min(inc[m - 1], start_inc[m]))
        return ans
