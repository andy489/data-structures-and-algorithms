# https://leetcode.com/problems/separate-the-digits-in-an-array/

# Solution: String Conversion — O(n * d) time, O(n * d) space
class Solution:
    def separateDigits(self, nums: list[int]) -> list[int]:
        return [int(d) for num in nums for d in str(num)]
