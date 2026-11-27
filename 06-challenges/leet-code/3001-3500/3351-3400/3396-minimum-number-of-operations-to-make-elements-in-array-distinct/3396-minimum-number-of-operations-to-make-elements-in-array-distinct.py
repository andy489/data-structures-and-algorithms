# https://leetcode.com/problems/minimum-number-of-operations-to-make-elements-in-array-distinct/

class Solution:
    def minimumOperations(self, nums: list[int]) -> int:
        seen = set()
        for i in range(len(nums) - 1, -1, -1):
            if nums[i] in seen:
                return i // 3 + 1
            seen.add(nums[i])
        return 0
