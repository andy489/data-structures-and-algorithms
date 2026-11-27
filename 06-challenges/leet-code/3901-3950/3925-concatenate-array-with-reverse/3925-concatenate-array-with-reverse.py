# https://leetcode.com/problems/concatenate-array-with-reverse/

class Solution:
    def concatenateArray(self, nums: list[int]) -> list[int]:
        return nums + nums[::-1]
