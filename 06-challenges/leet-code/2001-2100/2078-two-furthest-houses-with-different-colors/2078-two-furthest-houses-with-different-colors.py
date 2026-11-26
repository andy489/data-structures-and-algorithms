# https://leetcode.com/problems/two-furthest-houses-with-different-colors/

class Solution:
    def maxDistance(self, colors: list[int]) -> int:
        n = len(colors)
        res = 0
        for j in range(n - 1, 0, -1):
            if colors[j] != colors[0]:
                res = max(res, j)
                break
        for i in range(n - 1):
            if colors[i] != colors[n - 1]:
                res = max(res, n - 1 - i)
                break
        return res
