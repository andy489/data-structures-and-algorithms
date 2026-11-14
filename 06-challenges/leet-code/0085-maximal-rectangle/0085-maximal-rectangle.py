# https://leetcode.com/problems/maximal-rectangle/

class Solution:
    def maximalRectangle(self, matrix: list[list[str]]) -> int:
        def largest_in_histogram(heights):
            stack = [-1]
            max_area = 0
            for i in range(len(heights) + 1):
                h = 0 if i == len(heights) else heights[i]
                while stack[-1] != -1 and heights[stack[-1]] >= h:
                    height = heights[stack.pop()]
                    width = i - stack[-1] - 1
                    max_area = max(max_area, height * width)
                stack.append(i)
            return max_area

        if not matrix:
            return 0
        n = len(matrix[0])
        heights = [0] * n
        max_area = 0
        for row in matrix:
            for j in range(n):
                heights[j] = heights[j] + 1 if row[j] == '1' else 0
            max_area = max(max_area, largest_in_histogram(heights))
        return max_area
