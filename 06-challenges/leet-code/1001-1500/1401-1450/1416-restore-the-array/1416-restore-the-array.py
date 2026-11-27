# https://leetcode.com/problems/restore-the-array/

class Solution:
    def numberOfArrays(self, s: str, k: int) -> int:
        MOD = 10**9 + 7
        n = len(s)
        dp = [0] * (n + 1)
        dp[0] = 1
        for i in range(1, n + 1):
            num = 0
            mul = 1
            for j in range(i - 1, -1, -1):
                num += (ord(s[j]) - ord('0')) * mul
                mul *= 10
                if num > k:
                    break
                if s[j] != '0':
                    dp[i] = (dp[i] + dp[j]) % MOD
        return dp[n]
