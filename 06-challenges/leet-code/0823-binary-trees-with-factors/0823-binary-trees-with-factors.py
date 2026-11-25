# https://leetcode.com/problems/binary-trees-with-factors/

class Solution:
    def numFactoredBinaryTrees(self, arr: list[int]) -> int:
        MOD = 10 ** 9 + 7
        arr.sort()
        dp = {}
        for x in arr:
            dp[x] = 1
            for a in list(dp):
                if x % a == 0 and x // a in dp:
                    dp[x] = (dp[x] + dp[a] * dp[x // a]) % MOD
        return sum(dp.values()) % MOD
