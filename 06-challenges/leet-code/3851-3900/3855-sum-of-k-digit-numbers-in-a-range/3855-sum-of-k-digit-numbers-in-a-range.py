# https://leetcode.com/problems/sum-of-k-digit-numbers-in-a-range/

class Solution:
    def sumOfDigits(self, l: int, r: int, k: int) -> int:
        MOD = 10**9 + 7
        d = r - l + 1
        S = d * (l + r) // 2  # sum of digits in [l, r]
        # answer = S * d^(k-1) * (10^k - 1) / 9
        dk1 = pow(d, k - 1, MOD)
        tenK = pow(10, k, MOD)
        geo_sum = (tenK - 1) * pow(9, MOD - 2, MOD) % MOD
        return S % MOD * dk1 % MOD * geo_sum % MOD
