# https://leetcode.com/problems/find-the-number-of-possible-ways-for-an-event/

MOD = 10 ** 9 + 7


class Solution:
    def numberOfWays(self, n: int, x: int, y: int) -> int:
        max_k = min(n, x, y)
        # Stirling numbers S[i][j]
        S = [[0] * (max_k + 1) for _ in range(n + 1)]
        S[0][0] = 1
        for i in range(1, n + 1):
            for j in range(1, max_k + 1):
                S[i][j] = (j * S[i - 1][j] + S[i - 1][j - 1]) % MOD

        result = 0
        pxk = 1  # falling factorial P(x, k)
        pyk = 1  # falling factorial P(y, k)
        for k in range(1, max_k + 1):
            pxk = pxk * (x - k + 1) % MOD
            pyk = pyk * (y - k + 1) % MOD
            result = (result + S[n][k] * pxk % MOD * pyk) % MOD
        return result
