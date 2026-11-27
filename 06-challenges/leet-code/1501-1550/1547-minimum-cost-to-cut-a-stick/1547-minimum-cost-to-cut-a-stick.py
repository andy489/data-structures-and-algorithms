# https://leetcode.com/problems/minimum-cost-to-cut-a-stick/

class Solution:
    def minCost(self, n: int, cuts: list[int]) -> int:
        cuts = sorted(cuts)
        c = [0] + cuts + [n]
        m = len(c)
        dp = [[0] * m for _ in range(m)]
        for length in range(2, m):
            for left in range(m - length):
                right = left + length
                dp[left][right] = min(
                    dp[left][mid] + dp[mid][right] + c[right] - c[left]
                    for mid in range(left + 1, right)
                )
        return dp[0][m - 1]
