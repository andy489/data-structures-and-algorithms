# https://leetcode.com/problems/find-subsequence-of-length-k-with-the-largest-sum/

class Solution:
    def maxSubsequence(self, nums: list[int], k: int) -> list[int]:
        indices = sorted(range(len(nums)), key=lambda i: -nums[i])[:k]
        return [nums[i] for i in sorted(indices)]
