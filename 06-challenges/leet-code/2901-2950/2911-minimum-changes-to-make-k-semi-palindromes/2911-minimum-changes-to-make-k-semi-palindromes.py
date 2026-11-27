# https://leetcode.com/problems/minimum-changes-to-make-k-semi-palindromes/

class Solution:
    def minimumChanges(self, s: str, k: int) -> int:
        n = len(s)

        def semi_cost(i: int, j: int) -> int:
            length = j - i + 1
            best = float('inf')
            for d in range(1, length):
                if length % d != 0:
                    continue
                changes = 0
                for g in range(d):
                    lo, hi = i + g, j - (d - 1 - g)
                    while lo < hi:
                        if s[lo] != s[hi]:
                            changes += 1
                        lo += d
                        hi -= d
                best = min(best, changes)
            return best

        INF = float('inf')
        dp = [[INF] * (n + 1) for _ in range(k + 1)]
        dp[0][0] = 0

        for p in range(1, k + 1):
            for i in range(p, n - (k - p) + 1):
                for j in range(p - 1, i):
                    if dp[p - 1][j] < INF:
                        dp[p][i] = min(dp[p][i], dp[p - 1][j] + semi_cost(j, i - 1))

        return dp[k][n]
