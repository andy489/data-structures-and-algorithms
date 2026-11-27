# https://leetcode.com/problems/count-ways-to-make-array-with-product/

class Solution:
    def waysToFillArray(self, queries: list[list[int]]) -> list[int]:
        MOD = 10 ** 9 + 7
        from math import comb

        def ways(n, k):
            result = 1
            p = 2
            while p * p <= k:
                if k % p == 0:
                    e = 0
                    while k % p == 0:
                        e += 1
                        k //= p
                    result = result * comb(n + e - 1, e) % MOD
                p += 1
            if k > 1:
                result = result * n % MOD
            return result

        return [ways(n, k) for n, k in queries]
