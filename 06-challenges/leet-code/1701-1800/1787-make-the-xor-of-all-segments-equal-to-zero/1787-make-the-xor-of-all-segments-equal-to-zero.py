# https://leetcode.com/problems/make-the-xor-of-all-segments-equal-to-zero/

from collections import Counter

class Solution:
    def minChanges(self, nums: list[int], k: int) -> int:
        n = len(nums)
        max_val = 1 << 10
        INF = float('inf')
        dp = [INF] * max_val
        dp[0] = 0

        for j in range(k):
            group = nums[j::k]
            sz = len(group)
            cnt = Counter(group)
            global_min = min(dp)
            ndp = [global_min + sz] * max_val  # change all in this group
            for x in range(max_val):
                if dp[x] == INF:
                    continue
                for v, freq in cnt.items():
                    new_xor = x ^ v
                    cost = dp[x] + sz - freq
                    if cost < ndp[new_xor]:
                        ndp[new_xor] = cost
            dp = ndp

        return dp[0]
