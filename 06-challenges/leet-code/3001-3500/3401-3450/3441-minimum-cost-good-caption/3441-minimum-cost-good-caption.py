# https://leetcode.com/problems/minimum-cost-good-caption/
class Solution:
    def minCostGoodCaption(self, caption: str) -> str:
        n = len(caption)
        if n < 3:
            return ""

        INF = float('inf')
        dp = [INF] * (n + 1)
        dp[0] = 0
        best_group_size = [0] * (n + 1)
        best_char = [''] * (n + 1)

        vals = [ord(c) - ord('a') for c in caption]

        for i in range(3, n + 1):
            for g in range(3, 6):
                if g > i:
                    break
                l = i - g
                if dp[l] == INF:
                    continue
                group = vals[l:i]
                group_sorted = sorted(group)
                # Try median character and neighbors for minimum cost
                best_cost = INF
                best_c = None
                for c in range(26):
                    cost = sum(abs(v - c) for v in group)
                    if cost < best_cost or (cost == best_cost and chr(ord('a') + c) < best_c):
                        best_cost = cost
                        best_c = chr(ord('a') + c)
                total = dp[l] + best_cost
                if total < dp[i] or (total == dp[i] and best_c < best_char[i]):
                    dp[i] = total
                    best_group_size[i] = g
                    best_char[i] = best_c

        if dp[n] == INF:
            return ""

        result = [''] * n
        pos = n
        while pos > 0:
            g = best_group_size[pos]
            c = best_char[pos]
            for j in range(pos - g, pos):
                result[j] = c
            pos -= g

        return ''.join(result)
