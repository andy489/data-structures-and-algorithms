# https://leetcode.com/problems/find-indices-with-index-and-value-difference-i/

class Solution:
    def findIndices(self, nums: list[int], indexDifference: int, valueDifference: int) -> list[int]:
        n = len(nums)
        for i in range(n):
            for j in range(n):
                if abs(i - j) >= indexDifference and abs(nums[i] - nums[j]) >= valueDifference:
                    return [i, j]
        return [-1, -1]
