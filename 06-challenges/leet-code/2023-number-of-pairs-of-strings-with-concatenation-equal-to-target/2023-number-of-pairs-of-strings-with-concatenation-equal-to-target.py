# https://leetcode.com/problems/number-of-pairs-of-strings-with-concatenation-equal-to-target/

class Solution:
    def numOfPairs(self, nums: list[str], target: str) -> int:
        return sum(1 for i in range(len(nums)) for j in range(len(nums))
                   if i != j and nums[i] + nums[j] == target)
