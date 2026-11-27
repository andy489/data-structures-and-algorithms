# https://leetcode.com/problems/subsets/

class Solution:
    def subsets(self, nums: list[int]) -> list[list[int]]:
        result = []
        def backtrack(start, current):
            result.append(current[:])
            for i in range(start, len(nums)):
                current.append(nums[i])
                backtrack(i + 1, current)
                current.pop()
        backtrack(0, [])
        return result

class Solution2:
    def subsets(self, nums: list[int]) -> list[list[int]]:
        n = len(nums)
        result = []
        for mask in range(1 << n):
            subset = [nums[j] for j in range(n) if mask & (1 << j)]
            result.append(subset)
        return result
