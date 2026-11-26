# https://leetcode.com/problems/optimal-division/
# Solution: Greedy — O(n) time, O(n) space
class Solution:
    def optimalDivision(self, nums: list[int]) -> str:
        n = len(nums)
        if n == 1:
            return str(nums[0])
        if n == 2:
            return f"{nums[0]}/{nums[1]}"
        inner = '/'.join(map(str, nums[1:]))
        return f"{nums[0]}/({inner})"
