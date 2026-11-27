# https://leetcode.com/problems/height-checker/

class Solution:
    def heightChecker(self, heights: list[int]) -> int:
        return sum(a != b for a, b in zip(heights, sorted(heights)))
