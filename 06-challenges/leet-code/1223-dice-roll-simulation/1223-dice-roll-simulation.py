# https://leetcode.com/problems/dice-roll-simulation/

class Solution:
    def dieSimulator(self, n: int, rollMax: list[int]) -> int:
        MOD = 10**9 + 7
        dp = [[[0]*16 for _ in range(6)] for _ in range(n+1)]
        for j in range(6): dp[1][j][1] = 1
        for i in range(2, n+1):
            for j in range(6):
                total_other = sum(dp[i-1][pj][pk] for pj in range(6) if pj != j for pk in range(1, rollMax[pj]+1)) % MOD
                dp[i][j][1] = total_other
                for k in range(2, rollMax[j]+1):
                    dp[i][j][k] = dp[i-1][j][k-1]
        return sum(dp[n][j][k] for j in range(6) for k in range(1, rollMax[j]+1)) % MOD
