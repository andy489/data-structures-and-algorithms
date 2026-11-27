# https://leetcode.com/problems/delete-and-earn/

class Solution:
    def deleteAndEarn(self, nums: list[int]) -> int:
        max_val = max(nums)
        earn = [0] * (max_val + 1)
        for n in nums:
            earn[n] += n
        prev2 = prev1 = 0
        for e in earn[1:]:
            prev2, prev1 = prev1, max(prev1, prev2 + e)
        return prev1
