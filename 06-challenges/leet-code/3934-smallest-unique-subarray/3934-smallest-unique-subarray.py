# https://leetcode.com/problems/smallest-unique-subarray/

class Solution:
    def smallestUniqueSubarray(self, nums: list[int]) -> int:
        n = len(nums)
        MOD = (1 << 61) - 1
        BASE = 131

        def mul(a, b):
            return (a * b) % MOD

        def has_unique(k):
            pw = [1] * (k + 1)
            for i in range(1, k + 1):
                pw[i] = mul(pw[i - 1], BASE)
            h = [0] * (n + 1)
            for i in range(n):
                h[i + 1] = (mul(h[i], BASE) ^ nums[i]) % MOD
            freq = {}
            for i in range(n - k + 1):
                key = (h[i + k] ^ mul(h[i], pw[k])) % MOD
                freq[key] = freq.get(key, 0) + 1
            return any(v == 1 for v in freq.values())

        lo, hi = 1, n
        while lo < hi:
            mid = (lo + hi) // 2
            if has_unique(mid):
                hi = mid
            else:
                lo = mid + 1
        return lo
