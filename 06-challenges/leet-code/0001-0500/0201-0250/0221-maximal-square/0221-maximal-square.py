# https://leetcode.com/problems/maximal-square/

class Solution:
    def maximalSquare(self, matrix: list[list[str]]) -> int:
        m, n = len(matrix), len(matrix[0])
        dp = [[0] * n for _ in range(m)]
        max_side = 0

        for i in range(m):
            for j in range(n):
                if matrix[i][j] == '1':
                    if i == 0 or j == 0:
                        dp[i][j] = 1
                    else:
                        dp[i][j] = min(dp[i-1][j], dp[i][j-1], dp[i-1][j-1]) + 1
                    max_side = max(max_side, dp[i][j])
        return max_side * max_side


class Solution2:
    def maximalSquare(self, matrix: list[list[str]]) -> int:
        m, n = len(matrix), len(matrix[0])
        dp = [0] * n
        max_side = prev = 0

        for i in range(m):
            for j in range(n):
                temp = dp[j]
                if matrix[i][j] == '1':
                    if i == 0 or j == 0:
                        dp[j] = 1
                    else:
                        dp[j] = min(dp[j], dp[j-1], prev) + 1
                    max_side = max(max_side, dp[j])
                else:
                    dp[j] = 0
                prev = temp
        return max_side * max_side
