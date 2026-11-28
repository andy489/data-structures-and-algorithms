# https://leetcode.com/problems/minimum-cost-to-divide-array-into-subarrays/

class Solution:
    def minimumCost(self, nums: list[int], cost: list[int], k: int) -> int:
        n = len(nums)

        pref_nums = [0] * (n + 1)
        for i in range(n):
            pref_nums[i + 1] = pref_nums[i] + nums[i]

        suff_cost = [0] * (n + 1)
        for i in range(n - 1, -1, -1):
            suff_cost[i] = suff_cost[i + 1] + cost[i]

        INF = float('inf')
        dp = [INF] * (n + 1)
        dp[0] = 0

        for r in range(1, n + 1):
            min_val = INF
            for l in range(r):
                if dp[l] < INF:
                    candidate = dp[l] + (pref_nums[r] + k) * suff_cost[l]
                    if candidate < min_val:
                        min_val = candidate
            dp[r] = min_val - pref_nums[r] * suff_cost[r]

        return dp[n]
