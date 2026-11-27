# https://leetcode.com/problems/manhattan-distances-of-all-arrangements-of-pieces/

class Solution:
    def distanceSum(self, m: int, n: int, k: int) -> int:
        MOD = 10**9 + 7
        total = m * n

        def mod_pow(base: int, exp: int, mod: int) -> int:
            result = 1
            base %= mod
            while exp > 0:
                if exp & 1:
                    result = result * base % mod
                base = base * base % mod
                exp >>= 1
            return result

        # Precompute factorials
        fact = [1] * (total + 1)
        for i in range(1, total + 1):
            fact[i] = fact[i-1] * i % MOD
        inv_fact = [1] * (total + 1)
        inv_fact[total] = mod_pow(fact[total], MOD - 2, MOD)
        for i in range(total - 1, -1, -1):
            inv_fact[i] = inv_fact[i+1] * (i+1) % MOD

        def comb(a: int, b: int) -> int:
            if b < 0 or b > a:
                return 0
            return fact[a] * inv_fact[b] % MOD * inv_fact[a-b] % MOD

        # S_rows = sum_{d=1}^{m-1} d*(m-d)
        s_rows = sum(d * (m - d) for d in range(1, m)) % MOD
        # S_cols = sum_{d=1}^{n-1} d*(n-d)
        s_cols = sum(d * (n - d) for d in range(1, n)) % MOD

        c = comb(total - 2, k - 2)
        contrib = (n * n % MOD * s_rows + m * m % MOD * s_cols) % MOD
        return c * contrib % MOD
