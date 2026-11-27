# https://leetcode.com/problems/maximum-number-of-weeks-for-which-you-can-work/
class Solution:
    def numberOfWeeks(self, milestones: list[int]) -> int:
        max_m = max(milestones)
        rest = sum(milestones) - max_m
        if max_m <= rest + 1:
            return max_m + rest
        else:
            return 2 * rest + 1
