# https://leetcode.com/problems/find-all-good-strings/

from functools import lru_cache

class Solution:
    def findGoodStrings(self, n: int, s1: str, s2: str, evil: str) -> int:
        MOD = 10**9 + 7
        m = len(evil)
        fail = [0] * m
        j = 0
        for i in range(1, m):
            while j > 0 and evil[i] != evil[j]:
                j = fail[j-1]
            if evil[i] == evil[j]:
                j += 1
            fail[i] = j

        @lru_cache(maxsize=None)
        def dp(pos, kmp, tight_l, tight_r):
            if kmp == m:
                return 0
            if pos == n:
                return 1
            lo = ord(s1[pos]) if tight_l else ord('a')
            hi = ord(s2[pos]) if tight_r else ord('z')
            res = 0
            for c in range(lo, hi+1):
                nk = kmp
                while nk > 0 and ord(evil[nk]) != c:
                    nk = fail[nk-1]
                if ord(evil[nk]) == c:
                    nk += 1
                if nk == m:
                    continue
                res = (res + dp(pos+1, nk, tight_l and c==lo, tight_r and c==hi)) % MOD
            return res

        return dp(0, 0, True, True)
