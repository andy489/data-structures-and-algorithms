# https://leetcode.com/problems/count-submatrices-with-all-ones/

class Solution:
    def numSubmat(self, mat) -> int:
        m, n = len(mat), len(mat[0])
        height = [0] * n
        result = 0
        for i in range(m):
            for j in range(n):
                height[j] = height[j] + 1 if mat[i][j] == 1 else 0
            # count rectangles with bottom edge on row i
            stack = []  # (h, width)
            total = 0
            for j in range(n):
                width = 1
                while stack and stack[-1][0] >= height[j]:
                    h, w = stack.pop()
                    total -= h * w
                    width += w
                total += height[j] * width
                result += total
                stack.append((height[j], width))
        return result
