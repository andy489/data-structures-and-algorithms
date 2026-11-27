# https://leetcode.com/problems/minimum-number-of-operations-to-reinitialize-a-permutation/

class Solution:
    def reinitializePermutation(self, n: int) -> int:
        perm = list(range(n))
        orig = list(range(n))
        ops = 0
        while True:
            perm = [perm[i // 2] if i % 2 == 0 else perm[n // 2 + (i - 1) // 2] for i in range(n)]
            ops += 1
            if perm == orig:
                return ops
