# https://leetcode.com/problems/minimize-the-maximum-adjacent-element-difference/

# Solution: Binary Search on Answer — O(n log(max)) time, O(1) space
class Solution:
    def minDifference(self, nums: list[int]) -> int:
        n = len(nums)
        base = 0
        for i in range(n - 1):
            if nums[i] != -1 and nums[i + 1] != -1:
                base = max(base, abs(nums[i] - nums[i + 1]))

        if all(x == -1 for x in nums):
            return 0

        def feasible(d: int) -> bool:
            x_lo, x_hi = 1, 2 * 10 ** 9
            # Leading -1s
            first_real = next(k for k in range(n) if nums[k] != -1)
            if first_real > 0:
                x_lo = max(x_lo, nums[first_real] - d)
                x_hi = min(x_hi, nums[first_real] + d)

            i = 0
            while i < n:
                if nums[i] == -1:
                    i += 1
                    continue
                j = i + 1
                while j < n and nums[j] == -1:
                    j += 1
                if j < n:
                    if j - i > 1:
                        a, b = nums[i], nums[j]
                        if abs(a - b) > 2 * d:
                            return False
                        x_lo = max(x_lo, max(a, b) - d)
                        x_hi = min(x_hi, min(a, b) + d)
                else:
                    x_lo = max(x_lo, nums[i] - d)
                    x_hi = min(x_hi, nums[i] + d)
                i = j

            return x_lo <= x_hi

        lo, hi = base, 2 * 10 ** 9
        while lo < hi:
            mid = (lo + hi) // 2
            if feasible(mid):
                hi = mid
            else:
                lo = mid + 1
        return lo
