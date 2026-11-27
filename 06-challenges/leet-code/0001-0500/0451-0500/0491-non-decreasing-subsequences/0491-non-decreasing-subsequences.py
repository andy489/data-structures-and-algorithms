# https://leetcode.com/problems/non-decreasing-subsequences/

class Solution:
    def findSubsequences(self, nums: list) -> list:
        results = []

        def backtrack(start: int, current: list) -> None:
            if len(current) >= 2:
                results.append(list(current))
            used_at_level = set()
            for i in range(start, len(nums)):
                if nums[i] in used_at_level:
                    continue
                if not current or nums[i] >= current[-1]:
                    used_at_level.add(nums[i])
                    current.append(nums[i])
                    backtrack(i + 1, current)
                    current.pop()

        backtrack(0, [])
        return results
