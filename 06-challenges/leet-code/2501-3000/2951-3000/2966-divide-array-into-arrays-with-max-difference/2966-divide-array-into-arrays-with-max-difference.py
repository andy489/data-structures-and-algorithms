# https://leetcode.com/problems/divide-array-into-arrays-with-max-difference/
class Solution:
    def divideArray(self, nums: list[int], k: int) -> list[list[int]]:
        nums.sort()
        n = len(nums)
        result = []
        for i in range(0, n, 3):
            if nums[i + 2] - nums[i] > k:
                return []
            result.append([nums[i], nums[i + 1], nums[i + 2]])
        return result
