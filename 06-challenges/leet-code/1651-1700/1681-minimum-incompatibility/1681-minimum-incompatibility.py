# https://leetcode.com/problems/minimum-incompatibility/

class Solution:
    def minimumIncompatibility(self, nums: list[int], k: int) -> int:
        n = len(nums)
        group_size = n // k
        full = (1 << n) - 1
        cost = {}
        for mask in range(1, full + 1):
            if bin(mask).count('1') != group_size:
                continue
            vals = [nums[i] for i in range(n) if mask >> i & 1]
            if len(vals) == len(set(vals)):
                cost[mask] = max(vals) - min(vals)
        INF = float('inf')
        dp = [INF] * (full + 1)
        dp[0] = 0
        for mask in range(full + 1):
            if dp[mask] == INF:
                continue
            remaining = full ^ mask
            sub = remaining
            while sub:
                if sub in cost:
                    dp[mask | sub] = min(dp[mask | sub], dp[mask] + cost[sub])
                sub = (sub - 1) & remaining
        return dp[full] if dp[full] != INF else -1
