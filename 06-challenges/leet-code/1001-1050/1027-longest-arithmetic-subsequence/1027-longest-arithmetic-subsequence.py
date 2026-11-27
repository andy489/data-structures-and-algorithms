# https://leetcode.com/problems/longest-arithmetic-subsequence/

class Solution:
    def longestArithSeqLength(self, nums: list[int]) -> int:
        dp = [dict() for _ in nums]
        ans = 2
        for i in range(1, len(nums)):
            for j in range(i):
                diff = nums[i] - nums[j]
                dp[i][diff] = dp[j].get(diff, 1) + 1
                ans = max(ans, dp[i][diff])
        return ans
