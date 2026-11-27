# https://leetcode.com/problems/matrix-block-sum/

class Solution:
    def matrixBlockSum(self, mat: list[list[int]], k: int) -> list[list[int]]:
        m, n = len(mat), len(mat[0])
        prefix = [[0]*(n+1) for _ in range(m+1)]
        for i in range(1, m+1):
            for j in range(1, n+1):
                prefix[i][j] = mat[i-1][j-1] + prefix[i-1][j] + prefix[i][j-1] - prefix[i-1][j-1]
        ans = [[0]*n for _ in range(m)]
        for i in range(m):
            for j in range(n):
                r1,c1 = max(0,i-k), max(0,j-k)
                r2,c2 = min(m-1,i+k), min(n-1,j+k)
                ans[i][j] = prefix[r2+1][c2+1]-prefix[r1][c2+1]-prefix[r2+1][c1]+prefix[r1][c1]
        return ans
