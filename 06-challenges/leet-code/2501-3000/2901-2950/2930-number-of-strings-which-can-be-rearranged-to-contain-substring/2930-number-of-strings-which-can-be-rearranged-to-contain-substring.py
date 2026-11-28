# https://leetcode.com/problems/number-of-strings-which-can-be-rearranged-to-contain-substring/

class Solution:
    def stringCount(self, n: int) -> int:
        MOD = 10 ** 9 + 7

        def pw(b: int, e: int) -> int:
            return pow(b, e, MOD)

        # A: no 'l', B: at most 1 'e', C: no 't'
        a = pw(25, n)
        b = (pw(25, n) + n * pw(25, n - 1)) % MOD
        c = pw(25, n)
        ab = (pw(24, n) + n * pw(24, n - 1)) % MOD
        ac = pw(24, n)
        bc = (pw(24, n) + n * pw(24, n - 1)) % MOD
        abc = (pw(23, n) + n * pw(23, n - 1)) % MOD
        bad = (a + b + c - ab - ac - bc + abc) % MOD
        return (pw(26, n) - bad) % MOD
