# https://leetcode.com/problems/smallest-unique-subarray/

class Solution:
    def smallestUniqueSubarray(self, nums: list[int]) -> int:
        n = len(nums)
        MOD = (1 << 61) - 1
        BASE = 100003

        def mul(a, b): return (a * b) % MOD
        def add(a, b): return (a + b) % MOD
        def sub(a, b): return (a - b) % MOD

        def has_unique(k):
            pw = pow(BASE, k, MOD)
            h = 0
            for i in range(k):
                h = add(mul(h, BASE), nums[i] + 1)
            freq = {h: 1}
            for i in range(k, n):
                h = sub(add(mul(h, BASE), nums[i] + 1), mul(pw, nums[i - k] + 1))
                freq[h] = freq.get(h, 0) + 1
            return any(v == 1 for v in freq.values())

        lo, hi = 1, n
        while lo < hi:
            mid = (lo + hi) // 2
            if has_unique(mid):
                hi = mid
            else:
                lo = mid + 1
        return lo
