# https://leetcode.com/problems/largest-divisible-subset/

class Solution:
    def largestDivisibleSubset(self, nums: list[int]) -> list[int]:
        nums.sort()
        n = len(nums)
        dp = [1] * n
        parent = [-1] * n

        max_len, max_idx = 1, 0
        for i in range(1, n):
            for j in range(i):
                if nums[i] % nums[j] == 0 and dp[j] + 1 > dp[i]:
                    dp[i] = dp[j] + 1
                    parent[i] = j
            if dp[i] > max_len:
                max_len = dp[i]
                max_idx = i

        result = []
        i = max_idx
        while i >= 0:
            result.append(nums[i])
            i = parent[i]
        return result
