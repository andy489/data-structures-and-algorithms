# https://leetcode.com/problems/stone-game-vii/

class Solution:
    def stoneGameVII(self, stones: list[int]) -> int:
        n = len(stones)
        prefix = [0] * (n + 1)
        for i in range(n):
            prefix[i + 1] = prefix[i] + stones[i]
        dp = [[0] * n for _ in range(n)]
        for length in range(2, n + 1):
            for l in range(n - length + 1):
                r = l + length - 1
                sum_without_left  = prefix[r + 1] - prefix[l + 1]
                sum_without_right = prefix[r]     - prefix[l]
                dp[l][r] = max(
                    sum_without_left  - dp[l + 1][r],
                    sum_without_right - dp[l][r - 1]
                )
        return dp[0][n - 1]
