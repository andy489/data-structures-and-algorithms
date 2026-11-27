# https://leetcode.com/problems/maximum-and-minimum-sums-of-at-most-size-k-subsequences/

class Solution:
    def minMaxSums(self, nums: list[int], k: int) -> int:
        MOD = 10**9 + 7
        n = len(nums)
        nums.sort()

        def mod_pow(base: int, exp: int) -> int:
            result, base = 1, base % MOD
            while exp:
                if exp & 1:
                    result = result * base % MOD
                base = base * base % MOD
                exp >>= 1
            return result

        fact = [1] * (n + 1)
        for i in range(1, n + 1):
            fact[i] = fact[i-1] * i % MOD
        inv_fact = [1] * (n + 1)
        inv_fact[n] = mod_pow(fact[n], MOD - 2)
        for i in range(n - 1, -1, -1):
            inv_fact[i] = inv_fact[i+1] * (i+1) % MOD

        def comb(a: int, b: int) -> int:
            if b < 0 or b > a:
                return 0
            return fact[a] * inv_fact[b] % MOD * inv_fact[a-b] % MOD

        def sum_comb(a: int, r: int) -> int:
            return sum(comb(a, j) for j in range(min(r, a) + 1)) % MOD

        ans = 0
        for i in range(n):
            min_coeff = sum_comb(n - 1 - i, k - 1)
            max_coeff = sum_comb(i, k - 1)
            ans = (ans + nums[i] * (min_coeff + max_coeff)) % MOD
        return ans
