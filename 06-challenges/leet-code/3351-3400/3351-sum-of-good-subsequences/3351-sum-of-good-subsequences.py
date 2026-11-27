# https://leetcode.com/problems/sum-of-good-subsequences/

# Solution: DP with Hash Map (Count + Sum Tracking) — O(n) time, O(n) space
class Solution:
    def sumOfGoodSubsequences(self, nums: list[int]) -> int:
        MOD = 10 ** 9 + 7
        cnt: dict[int, int] = {}
        total: dict[int, int] = {}

        for v in nums:
            new_cnt = (cnt.get(v - 1, 0) + cnt.get(v + 1, 0) + 1) % MOD
            new_sum = (total.get(v - 1, 0) + total.get(v + 1, 0) + v * new_cnt) % MOD
            cnt[v] = (cnt.get(v, 0) + new_cnt) % MOD
            total[v] = (total.get(v, 0) + new_sum) % MOD

        return sum(total.values()) % MOD
