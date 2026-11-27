# https://leetcode.com/problems/closest-subsequence-sum/

import bisect

class Solution:
    def minAbsDifference(self, nums: list[int], goal: int) -> int:
        def subset_sums(arr: list[int]) -> list[int]:
            sums = [0]
            for x in arr:
                sums += [s + x for s in sums]
            return sums

        n = len(nums)
        half = n // 2
        left_sums = subset_sums(nums[:half])
        right_sums = sorted(subset_sums(nums[half:]))
        ans = float('inf')
        for ls in left_sums:
            target = goal - ls
            idx = bisect.bisect_left(right_sums, target)
            for i in [idx - 1, idx]:
                if 0 <= i < len(right_sums):
                    ans = min(ans, abs(ls + right_sums[i] - goal))
        return ans
