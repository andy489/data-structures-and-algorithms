# https://leetcode.com/problems/make-sum-divisible-by-p/

class Solution:
    def minSubarray(self, nums: list[int], p: int) -> int:
        total_mod = sum(nums) % p
        if total_mod == 0:
            return 0
        last_seen = {0: -1}
        pref_mod = 0
        min_len = len(nums)
        for i, x in enumerate(nums):
            pref_mod = (pref_mod + x) % p
            need = (pref_mod - total_mod + p) % p
            if need in last_seen:
                min_len = min(min_len, i - last_seen[need])
            last_seen[pref_mod] = i
        return -1 if min_len == len(nums) else min_len
