# https://leetcode.com/problems/maximum-sum-of-3-non-overlapping-subarrays/

class Solution:
    def maxSumOfThreeSubarrays(self, nums: list, k: int) -> list:
        n = len(nums)
        m = n - k + 1
        sums = [0] * m
        window = sum(nums[:k])
        sums[0] = window
        for i in range(1, m):
            window += nums[i + k - 1] - nums[i - 1]
            sums[i] = window

        left = [0] * m
        best = 0
        for i in range(m):
            if sums[i] > sums[best]:
                best = i
            left[i] = best

        right = [0] * m
        best = m - 1
        for i in range(m - 1, -1, -1):
            if sums[i] >= sums[best]:
                best = i
            right[i] = best

        result = [-1, -1, -1]
        max_sum = 0
        for mid in range(k, m - k):
            l, r = left[mid - k], right[mid + k]
            total = sums[l] + sums[mid] + sums[r]
            if total > max_sum:
                max_sum = total
                result = [l, mid, r]
        return result
