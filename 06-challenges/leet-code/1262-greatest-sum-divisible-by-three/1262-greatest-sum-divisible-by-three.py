# https://leetcode.com/problems/greatest-sum-divisible-by-three/

class Solution:
    def maxSumDivThree(self, nums: list[int]) -> int:
        dp = [0, float('-inf'), float('-inf')]
        for x in nums:
            ndp = dp[:]
            for r in range(3):
                if dp[r] != float('-inf'):
                    ndp[(r + x) % 3] = max(ndp[(r + x) % 3], dp[r] + x)
            dp = ndp
        return dp[0]
