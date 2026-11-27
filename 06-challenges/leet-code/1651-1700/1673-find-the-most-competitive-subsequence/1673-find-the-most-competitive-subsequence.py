# https://leetcode.com/problems/find-the-most-competitive-subsequence/

class Solution:
    def mostCompetitive(self, nums: list[int], k: int) -> list[int]:
        n = len(nums)
        stack = []
        for i, v in enumerate(nums):
            while stack and stack[-1] > v and len(stack) + (n - i) > k:
                stack.pop()
            if len(stack) < k:
                stack.append(v)
        return stack
