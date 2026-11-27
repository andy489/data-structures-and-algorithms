# https://leetcode.com/problems/maximum-side-length-of-a-square-with-sum-less-than-or-equal-to-threshold/

class Solution:
    def maxSideLength(self, mat: list[list[int]], threshold: int) -> int:
        m, n = len(mat), len(mat[0])
        pre = [[0]*(n+1) for _ in range(m+1)]
        for i in range(1,m+1):
            for j in range(1,n+1):
                pre[i][j] = mat[i-1][j-1]+pre[i-1][j]+pre[i][j-1]-pre[i-1][j-1]
        res = 0
        for k in range(1, min(m,n)+1):
            found = False
            for i in range(k, m+1):
                for j in range(k, n+1):
                    if pre[i][j]-pre[i-k][j]-pre[i][j-k]+pre[i-k][j-k] <= threshold:
                        res = k; found = True; break
                if found: break
            if not found: break
        return res
