# https://leetcode.com/problems/zero-array-transformation-iv/

class Solution:
    def minZeroArray(self, nums: list[int], queries: list[list[int]]) -> int:
        n, q = len(nums), len(queries)

        def can_zero(k: int) -> bool:
            for i in range(n):
                if nums[i] == 0:
                    continue
                target = nums[i]
                dp = [False] * (target + 1)
                dp[0] = True
                for j in range(k):
                    l, r, val = queries[j]
                    if l <= i <= r:
                        for s in range(target, val - 1, -1):
                            if dp[s - val]:
                                dp[s] = True
                if not dp[target]:
                    return False
            return True

        lo, hi, ans = 0, q, -1
        while lo <= hi:
            mid = (lo + hi) // 2
            if can_zero(mid):
                ans = mid
                hi = mid - 1
            else:
                lo = mid + 1
        return ans
