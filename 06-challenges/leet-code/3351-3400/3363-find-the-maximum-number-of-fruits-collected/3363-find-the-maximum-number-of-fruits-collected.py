# https://leetcode.com/problems/find-the-maximum-number-of-fruits-collected/

# Solution: Independent DP for Each Side Child — O(n^2) time, O(n^2) space
class Solution:
    def maxCollectedFruits(self, fruits: list[list[int]]) -> int:
        n = len(fruits)
        NEG_INF = float('-inf')

        # Child 1: forced diagonal
        diag = sum(fruits[i][i] for i in range(n))

        # Child 2: (0, n-1) -> (n-1, n-1), row increases each step
        dp2 = [[NEG_INF] * n for _ in range(n)]
        dp2[0][n - 1] = fruits[0][n - 1]
        for i in range(1, n):
            for j in range(n):
                if i == j:
                    continue
                best = NEG_INF
                for dj in (-1, 0, 1):
                    pj = j - dj  # previous column
                    if 0 <= pj < n and dp2[i - 1][pj] != NEG_INF:
                        best = max(best, dp2[i - 1][pj])
                if best != NEG_INF:
                    dp2[i][j] = best + fruits[i][j]
        child2 = dp2[n - 1][n - 1]

        # Child 3: (n-1, 0) -> (n-1, n-1), column increases each step
        dp3 = [[NEG_INF] * n for _ in range(n)]
        dp3[n - 1][0] = fruits[n - 1][0]
        for j in range(1, n):
            for i in range(n):
                if i == j:
                    continue
                best = NEG_INF
                for di in (-1, 0, 1):
                    pi = i - di  # previous row
                    if 0 <= pi < n and dp3[pi][j - 1] != NEG_INF:
                        best = max(best, dp3[pi][j - 1])
                if best != NEG_INF:
                    dp3[i][j] = best + fruits[i][j]
        child3 = dp3[n - 1][n - 1]

        return diag + child2 + child3
