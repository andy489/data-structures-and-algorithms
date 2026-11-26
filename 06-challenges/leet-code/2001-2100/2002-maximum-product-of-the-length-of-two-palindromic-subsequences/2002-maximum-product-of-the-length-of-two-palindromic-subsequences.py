# https://leetcode.com/problems/maximum-product-of-the-length-of-two-palindromic-subsequences/

class Solution:
    def maxProduct(self, s: str) -> int:
        n = len(s)
        full = 1 << n
        palin = [0] * full
        for mask in range(1, full):
            chars = [s[i] for i in range(n) if mask >> i & 1]
            if chars == chars[::-1]:
                palin[mask] = len(chars)
        res = 0
        for mask in range(1, full):
            if not palin[mask]:
                continue
            comp = (full - 1) ^ mask
            sub = comp
            while sub:
                if palin[sub]:
                    res = max(res, palin[mask] * palin[sub])
                sub = (sub - 1) & comp
        return res
