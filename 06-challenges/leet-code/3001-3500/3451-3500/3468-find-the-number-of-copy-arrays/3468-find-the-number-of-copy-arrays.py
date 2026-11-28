# https://leetcode.com/problems/find-the-number-of-copy-arrays/

class Solution:
    def countArrays(self, original: list[int], bounds: list[list[int]]) -> int:
        lo = float('-inf')
        hi = float('inf')
        for i in range(len(original)):
            diff = original[i] - original[0]
            lo = max(lo, bounds[i][0] - diff)
            hi = min(hi, bounds[i][1] - diff)
        return max(0, hi - lo + 1)
