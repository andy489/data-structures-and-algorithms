# https://leetcode.com/problems/count-the-number-of-infection-sequences/
class Solution:
    def numberOfSequence(self, n: int, sick: list[int]) -> int:
        MOD = 10 ** 9 + 7

        fact = [1] * (n + 1)
        for i in range(1, n + 1):
            fact[i] = fact[i - 1] * i % MOD
        inv_fact = [1] * (n + 1)
        inv_fact[n] = pow(fact[n], MOD - 2, MOD)
        for i in range(n - 1, -1, -1):
            inv_fact[i] = inv_fact[i + 1] * (i + 1) % MOD

        m = len(sick)
        total = n - m

        gaps = [0] * (m + 1)
        gaps[0] = sick[0]
        for i in range(1, m):
            gaps[i] = sick[i] - sick[i - 1] - 1
        gaps[m] = n - 1 - sick[-1]

        ans = fact[total]
        for i in range(m + 1):
            g = gaps[i]
            ans = ans * inv_fact[g] % MOD
            if 0 < i < m and g > 0:
                ans = ans * pow(2, g - 1, MOD) % MOD
        return ans
