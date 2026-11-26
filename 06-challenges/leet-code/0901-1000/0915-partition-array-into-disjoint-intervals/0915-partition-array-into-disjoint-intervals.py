# https://leetcode.com/problems/partition-array-into-disjoint-intervals/

class Solution:
    def partitionDisjoint(self, nums: list) -> int:
        n = len(nums)
        min_right = [0] * n
        min_right[-1] = nums[-1]
        for i in range(n - 2, -1, -1):
            min_right[i] = min(nums[i], min_right[i + 1])
        left_max = nums[0]
        for i in range(1, n):
            left_max = max(left_max, nums[i - 1])
            if left_max <= min_right[i]:
                return i
        return n - 1
