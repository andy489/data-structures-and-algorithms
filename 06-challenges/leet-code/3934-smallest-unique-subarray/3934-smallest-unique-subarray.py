# https://leetcode.com/problems/smallest-unique-subarray/

class Solution:
    def minUniqueSubarrayLength(self, nums: list[int]) -> int:
        n = len(nums)

        def has_unique(k):
            freq = {}
            key = tuple(nums[:k])
            freq[key] = freq.get(key, 0) + 1
            for i in range(k, n):
                key = key[1:] + (nums[i],)
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
