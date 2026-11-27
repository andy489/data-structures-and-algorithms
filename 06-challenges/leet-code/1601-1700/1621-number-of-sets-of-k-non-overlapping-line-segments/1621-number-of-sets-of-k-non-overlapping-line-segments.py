# https://leetcode.com/problems/number-of-sets-of-k-non-overlapping-line-segments/

class Solution:
    def numberOfSets(self, n: int, k: int) -> int:
        MOD = 10 ** 9 + 7
        # Answer is C(n + k - 1, 2k)
        from math import comb
        return comb(n + k - 1, 2 * k) % MOD
