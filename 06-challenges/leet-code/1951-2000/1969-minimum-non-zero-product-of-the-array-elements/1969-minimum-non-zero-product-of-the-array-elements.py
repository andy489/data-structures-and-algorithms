# https://leetcode.com/problems/minimum-non-zero-product-of-the-array-elements/
class Solution:
    def minNonZeroProduct(self, p: int) -> int:
        MOD = 10 ** 9 + 7
        max_val = (1 << p) - 1
        pair_val = max_val - 1
        pair_count = (max_val - 1) // 2
        return (max_val % MOD) * pow(pair_val % MOD, pair_count, MOD) % MOD
