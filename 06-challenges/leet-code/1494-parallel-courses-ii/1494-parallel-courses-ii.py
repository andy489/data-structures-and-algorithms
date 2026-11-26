# https://leetcode.com/problems/parallel-courses-ii/

class Solution:
    def minNumberOfSemesters(self, n: int, dependencies: list[list[int]], k: int) -> int:
        pre = [0] * n
        for a, b in dependencies:
            pre[b-1] |= 1 << (a-1)
        dp = [float('inf')] * (1 << n)
        dp[0] = 0
        for mask in range(1 << n):
            if dp[mask] == float('inf'):
                continue
            avail = 0
            for i in range(n):
                if not (mask >> i & 1) and (mask & pre[i]) == pre[i]:
                    avail |= 1 << i
            sub = avail
            while sub:
                if bin(sub).count('1') <= k:
                    dp[mask | sub] = min(dp[mask | sub], dp[mask] + 1)
                sub = (sub - 1) & avail
        return dp[(1 << n) - 1]
