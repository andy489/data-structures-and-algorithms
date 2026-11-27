# https://leetcode.com/problems/minimum-number-of-operations-to-make-string-sorted/

class Solution:
    def makeStringSorted(self, s: str) -> int:
        MOD = 10**9 + 7
        n = len(s)
        cnt = [0] * 26
        for c in s:
            cnt[ord(c) - ord('a')] += 1

        fact = [1] * (n + 1)
        for i in range(1, n + 1):
            fact[i] = fact[i - 1] * i % MOD

        inv_fact = [1] * (n + 1)
        inv_fact[n] = pow(fact[n], MOD - 2, MOD)
        for i in range(n - 1, -1, -1):
            inv_fact[i] = inv_fact[i + 1] * (i + 1) % MOD

        ans = 0
        for i, c in enumerate(s):
            cur = ord(c) - ord('a')
            smaller = sum(cnt[:cur])
            remaining = n - 1 - i
            ways = fact[remaining]
            for j in range(26):
                c2 = cnt[j] - (1 if j == cur else 0)
                ways = ways * inv_fact[c2] % MOD
            ans = (ans + smaller * ways) % MOD
            cnt[cur] -= 1
        return ans
