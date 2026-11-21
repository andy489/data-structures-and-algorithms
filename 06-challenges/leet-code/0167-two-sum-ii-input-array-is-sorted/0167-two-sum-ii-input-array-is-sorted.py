# https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/

# Two pointers — O(n) time, O(1) space
class Solution:
    def twoSum(self, numbers: list[int], target: int) -> list[int]:
        lo, hi = 0, len(numbers) - 1
        while lo < hi:
            s = numbers[lo] + numbers[hi]
            if s == target:
                return [lo + 1, hi + 1]
            if s < target:
                lo += 1
            else:
                hi -= 1
        return [-1, -1]
