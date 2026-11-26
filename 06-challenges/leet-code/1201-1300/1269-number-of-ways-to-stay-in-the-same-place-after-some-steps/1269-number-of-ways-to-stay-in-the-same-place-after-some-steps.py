# https://leetcode.com/problems/number-of-ways-to-stay-in-the-same-place-after-some-steps/

class Solution:
    def numWays(self, steps: int, arrLen: int) -> int:
        MOD = 10**9+7
        max_pos = min(steps//2, arrLen-1)
        dp = [0]*(max_pos+1); dp[0] = 1
        for _ in range(steps):
            ndp = [0]*(max_pos+1)
            for j in range(max_pos+1):
                if dp[j]:
                    ndp[j] = (ndp[j]+dp[j])%MOD
                    if j>0: ndp[j-1]=(ndp[j-1]+dp[j])%MOD
                    if j<max_pos: ndp[j+1]=(ndp[j+1]+dp[j])%MOD
            dp=ndp
        return dp[0]
