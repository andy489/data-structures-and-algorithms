# https://leetcode.com/problems/maximum-value-of-k-coins-from-piles/
class Solution:
    def maxValueOfCoins(self, piles: List[List[int]], k: int) -> int:
        dp = [0] * (k + 1)
        for pile in piles:
            prefix = [0] * (len(pile) + 1)
            for i, coin in enumerate(pile):
                prefix[i + 1] = prefix[i] + coin
            for j in range(k, -1, -1):
                for take in range(1, min(len(pile), j) + 1):
                    dp[j] = max(dp[j], dp[j - take] + prefix[take])
        return dp[k]
