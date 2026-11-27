# https://leetcode.com/problems/stone-game-iv/

class Solution:
    def winnerSquareGame(self, n: int) -> bool:
        dp = [False] * (n + 1)
        for i in range(1, n + 1):
            k = 1
            while k * k <= i:
                if not dp[i - k * k]:
                    dp[i] = True
                    break
                k += 1
        return dp[n]
