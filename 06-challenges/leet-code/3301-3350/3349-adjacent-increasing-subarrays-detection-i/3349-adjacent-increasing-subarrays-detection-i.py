# https://leetcode.com/problems/adjacent-increasing-subarrays-detection-i/

# Solution: Precompute Run Lengths — O(n) time, O(n) space
class Solution:
    def hasIncreasingSubarrays(self, nums: list[int], k: int) -> bool:
        n = len(nums)
        inc = [1] * n
        for i in range(1, n):
            if nums[i] > nums[i - 1]:
                inc[i] = inc[i - 1] + 1
        for a in range(n - 2 * k + 1):
            if inc[a + k - 1] >= k and inc[a + 2 * k - 1] >= k:
                return True
        return False
