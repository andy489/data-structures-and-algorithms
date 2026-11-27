# https://leetcode.com/problems/minimum-swaps-to-move-zeros-to-end/
class Solution:
    def minimumSwaps(self, nums: list[int]) -> int:
        pos = 0
        swaps = 0
        for i, v in enumerate(nums):
            if v != 0:
                if i > pos:
                    swaps += 1
                pos += 1
        return swaps
