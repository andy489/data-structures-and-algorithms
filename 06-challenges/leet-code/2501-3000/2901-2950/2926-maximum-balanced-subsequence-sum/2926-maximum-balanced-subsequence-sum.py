# https://leetcode.com/problems/maximum-balanced-subsequence-sum/

import bisect

class Solution:
    def maxBalancedSubsequenceSum(self, nums: list[int]) -> int:
        n = len(nums)
        a = [nums[i] - i for i in range(n)]
        sorted_vals = sorted(set(a))
        rank = {v: i for i, v in enumerate(sorted_vals)}
        m = len(sorted_vals)
        bit = [-float('inf')] * (m + 1)

        def update(pos: int, val: float) -> None:
            pos += 1
            while pos <= m:
                if bit[pos] < val:
                    bit[pos] = val
                pos += pos & (-pos)

        def query(pos: int) -> float:
            pos += 1
            res = -float('inf')
            while pos > 0:
                if bit[pos] > res:
                    res = bit[pos]
                pos -= pos & (-pos)
            return res

        ans = -float('inf')
        for i in range(n):
            pos = rank[a[i]]
            prev = query(pos)
            dp = nums[i] + (prev if prev > 0 else 0)
            ans = max(ans, dp)
            update(pos, dp)
        return ans
