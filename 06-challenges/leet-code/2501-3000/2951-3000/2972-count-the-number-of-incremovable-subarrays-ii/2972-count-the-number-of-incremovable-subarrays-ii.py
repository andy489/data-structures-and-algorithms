# https://leetcode.com/problems/count-the-number-of-incremovable-subarrays-ii/
class Solution:
    def incremovableSubarrayCount(self, nums: list[int]) -> int:
        n = len(nums)
        # Find longest strictly increasing prefix
        prefix_end = 0
        while prefix_end + 1 < n and nums[prefix_end] < nums[prefix_end + 1]:
            prefix_end += 1
        # If whole array is strictly increasing
        if prefix_end == n - 1:
            return n * (n + 1) // 2
        # Count subarrays starting at index > prefix_end (remove up to end)
        count = n - prefix_end
        j = n - 1
        for i in range(prefix_end, -1, -1):
            # Find smallest j such that prefix[0..i-1] + suffix[j+1..n-1] is valid
            while j >= 0 and (i == 0 or nums[i - 1] < nums[j]):
                j -= 1
            count += n - (j + 1)
            if i > 0 and nums[i - 1] >= nums[i]:
                break
        return count
