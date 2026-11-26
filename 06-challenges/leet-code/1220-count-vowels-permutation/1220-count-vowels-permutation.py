# https://leetcode.com/problems/count-vowels-permutation/

class Solution:
    def countVowelPermutation(self, n: int) -> int:
        MOD = 10**9 + 7
        a = e = i = o = u = 1
        for _ in range(n - 1):
            a, e, i, o, u = (e + i + u) % MOD, (a + i) % MOD, (e + o) % MOD, i % MOD, (i + o) % MOD
        return (a + e + i + o + u) % MOD
