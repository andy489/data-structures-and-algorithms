# https://leetcode.com/problems/maximum-xor-product/

class Solution:
    def maximumXorProduct(self, a: int, b: int, n: int) -> int:
        MOD = 10**9 + 7
        for i in range(n - 1, -1, -1):
            bit_a = (a >> i) & 1
            bit_b = (b >> i) & 1
            if bit_a == bit_b:
                a |= (1 << i)
                b |= (1 << i)
            else:
                if a < b:
                    a |= (1 << i)
                    b &= ~(1 << i)
                else:
                    b |= (1 << i)
                    a &= ~(1 << i)
        return (a % MOD) * (b % MOD) % MOD
