# https://leetcode.com/problems/image-smoother/

class Solution:
    def imageSmoother(self, img: list) -> list:
        m, n = len(img), len(img[0])
        res = [[0] * n for _ in range(m)]
        for i in range(m):
            for j in range(n):
                total, cnt = 0, 0
                for di in (-1, 0, 1):
                    for dj in (-1, 0, 1):
                        ni, nj = i + di, j + dj
                        if 0 <= ni < m and 0 <= nj < n:
                            total += img[ni][nj]
                            cnt += 1
                res[i][j] = total // cnt
        return res
