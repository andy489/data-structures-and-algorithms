# https://leetcode.com/problems/count-the-number-of-arrays-with-k-matching-adjacent-elements/
class Solution:
    def countGoodArrays(self, n: int, m: int, k: int) -> int:
        MOD = 10 ** 9 + 7

        def power(base, exp, mod):
            result = 1
            base %= mod
            while exp > 0:
                if exp & 1:
                    result = result * base % mod
                base = base * base % mod
                exp >>= 1
            return result

        def modinv(a):
            return power(a, MOD - 2, MOD)

        def comb(n, r):
            if r < 0 or r > n:
                return 0
            fact = [1] * (n + 1)
            for i in range(1, n + 1):
                fact[i] = fact[i - 1] * i % MOD
            return fact[n] * modinv(fact[r]) % MOD * modinv(fact[n - r]) % MOD

        # C(n-1, k) * m * (m-1)^(n-k-1)
        return comb(n - 1, k) * m % MOD * power(m - 1, n - k - 1, MOD) % MOD
