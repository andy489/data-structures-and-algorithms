# https://leetcode.com/problems/largest-rectangle-in-histogram/

class Solution:
    def largestRectangleArea(self, heights: list[int]) -> int:
        n = len(heights)
        stack = [-1]
        max_area = 0
        for i in range(n + 1):
            h = 0 if i == n else heights[i]
            while stack[-1] != -1 and heights[stack[-1]] >= h:
                height = heights[stack.pop()]
                width = i - stack[-1] - 1
                max_area = max(max_area, height * width)
            stack.append(i)
        return max_area
