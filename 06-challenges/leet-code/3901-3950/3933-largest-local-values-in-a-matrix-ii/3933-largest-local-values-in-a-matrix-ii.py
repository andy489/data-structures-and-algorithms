# https://leetcode.com/problems/largest-local-values-in-a-matrix-ii/

class Solution:
    def largestLocal(self, matrix: list[list[int]]) -> int:
        n = len(matrix)
        m = len(matrix[0])
        count = 0
        for r in range(n):
            for c in range(m):
                x = matrix[r][c]
                if x == 0:
                    continue
                is_max = True
                for dr in range(-x, x + 1):
                    if not is_max:
                        break
                    for dc in range(-x, x + 1):
                        if abs(dr) == x and abs(dc) == x:
                            continue
                        nr, nc = r + dr, c + dc
                        if 0 <= nr < n and 0 <= nc < m:
                            if matrix[nr][nc] > x:
                                is_max = False
                                break
                if is_max:
                    count += 1
        return count
