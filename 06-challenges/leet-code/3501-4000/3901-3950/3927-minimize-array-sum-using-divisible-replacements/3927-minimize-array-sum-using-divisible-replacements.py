# https://leetcode.com/problems/minimize-array-sum-using-divisible-replacements/

class Solution:
    def minimizeSum(self, nums: list[int]) -> int:
        val_set = set(nums)
        total = 0
        for v in nums:
            best = v
            d = 1
            while d * d <= v:
                if v % d == 0:
                    if d in val_set:
                        best = min(best, d)
                    if v // d in val_set:
                        best = min(best, v // d)
                d += 1
            total += best
        return total
