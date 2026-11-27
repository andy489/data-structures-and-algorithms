# https://leetcode.com/problems/decrease-elements-to-make-array-zigzag/

class Solution:
    def movesToMakeZigzag(self, nums: list[int]) -> int:
        n = len(nums)
        cost = [0, 0]
        for p in range(2):
            for i in range(p, n, 2):
                min_nb = min(
                    (nums[i - 1] if i > 0 else float('inf')),
                    (nums[i + 1] if i < n - 1 else float('inf'))
                )
                if nums[i] >= min_nb:
                    cost[p] += nums[i] - min_nb + 1
        return min(cost)
