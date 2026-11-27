# https://leetcode.com/problems/count-digit-appearances/
class Solution:
    def countDigitAppearances(self, nums: list[int], digit: int) -> int:
        target = str(digit)
        return sum(str(num).count(target) for num in nums)
