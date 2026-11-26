# https://leetcode.com/problems/maximum-area-of-longest-diagonal-rectangle/

class Solution:
    def maximumAreaOfLongestDiagonalRectangle(self, dimensions: list[list[int]]) -> int:
        max_diag2 = max_area = 0
        for l, w in dimensions:
            diag2, area = l*l + w*w, l*w
            if diag2 > max_diag2 or (diag2 == max_diag2 and area > max_area):
                max_diag2, max_area = diag2, area
        return max_area
