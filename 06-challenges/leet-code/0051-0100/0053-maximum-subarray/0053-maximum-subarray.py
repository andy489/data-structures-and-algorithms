# https://leetcode.com/problems/maximum-subarray/

class Solution:
    def maxSubArray(self, nums: list[int]) -> int:
        max_sum = curr = nums[0]
        for x in nums[1:]:
            curr = max(x, curr + x)
            max_sum = max(max_sum, curr)
        return max_sum


# Solution 2: Divide and Conquer — O(n log n) time, O(log n) space
class Solution2:
    def maxSubArray(self, nums: list[int]) -> int:
        def solve(lo, hi):
            if lo == hi:
                return nums[lo]
            mid = (lo + hi) // 2
            left = solve(lo, mid)
            right = solve(mid + 1, hi)
            left_sum, s = float('-inf'), 0
            for i in range(mid, lo - 1, -1):
                s += nums[i]
                left_sum = max(left_sum, s)
            right_sum, s = float('-inf'), 0
            for i in range(mid + 1, hi + 1):
                s += nums[i]
                right_sum = max(right_sum, s)
            return max(left, right, left_sum + right_sum)

        return solve(0, len(nums) - 1)
