# https://leetcode.com/problems/zero-array-transformation-ii/

# Solution: Binary Search + Difference Array — O((n + q) log q) time, O(n) space
class Solution:
    def minZeroArray(self, nums: list[int], queries: list[list[int]]) -> int:
        n = len(nums)

        def feasible(k: int) -> bool:
            diff = [0] * (n + 1)
            for i in range(k):
                l, r, val = queries[i]
                diff[l] += val
                diff[r + 1] -= val
            coverage = 0
            for i in range(n):
                coverage += diff[i]
                if coverage < nums[i]:
                    return False
            return True

        if feasible(0):
            return 0
        lo, hi = 1, len(queries)
        while lo < hi:
            mid = (lo + hi) // 2
            if feasible(mid):
                hi = mid
            else:
                lo = mid + 1
        return lo if feasible(lo) else -1
