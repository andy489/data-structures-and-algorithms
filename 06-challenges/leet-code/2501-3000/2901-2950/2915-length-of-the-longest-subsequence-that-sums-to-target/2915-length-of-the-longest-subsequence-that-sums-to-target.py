# https://leetcode.com/problems/length-of-the-longest-subsequence-that-sums-to-target/

class Solution:
    def lengthOfLongestSubsequence(self, nums: list[int], target: int) -> int:
        dp = [float('-inf')] * (target + 1)
        dp[0] = 0

        for num in nums:
            for s in range(target, num - 1, -1):
                if dp[s - num] != float('-inf'):
                    dp[s] = max(dp[s], dp[s - num] + 1)

        return dp[target] if dp[target] >= 0 else -1
