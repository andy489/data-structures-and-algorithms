# https://leetcode.com/problems/stone-game-iii/

class Solution:
    def stoneGameIII(self, stoneValue: list[int]) -> str:
        n = len(stoneValue)
        dp = [0] * (n + 1)
        for i in range(n - 1, -1, -1):
            dp[i] = float('-inf')
            s = 0
            for k in range(1, 4):
                if i + k > n:
                    break
                s += stoneValue[i + k - 1]
                dp[i] = max(dp[i], s - dp[i + k])
        total = sum(stoneValue)
        alice, bob = dp[0], total - dp[0]
        return "Alice" if alice > bob else "Bob" if alice < bob else "Tie" 
