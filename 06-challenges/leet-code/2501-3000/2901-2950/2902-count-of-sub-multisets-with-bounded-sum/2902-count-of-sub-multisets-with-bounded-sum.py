# https://leetcode.com/problems/count-of-sub-multisets-with-bounded-sum/

from collections import Counter

class Solution:
    def countSubMultisets(self, nums: list[int], l: int, r: int) -> int:
        MOD = 10**9 + 7
        freq = Counter(nums)
        zero_count = freq.pop(0, 0)

        dp = [0] * (r + 1)
        dp[0] = 1

        for v, c in freq.items():
            if v > r:
                continue
            ndp = [0] * (r + 1)
            for rem in range(v):
                window_sum = 0
                positions = list(range(rem, r + 1, v))
                for t, p in enumerate(positions):
                    window_sum = (window_sum + dp[p]) % MOD
                    if t > c:
                        window_sum = (window_sum - dp[positions[t - c - 1]]) % MOD
                    ndp[p] = window_sum
            dp = ndp

        ans = sum(dp[l:r+1]) % MOD
        return ans * (zero_count + 1) % MOD
