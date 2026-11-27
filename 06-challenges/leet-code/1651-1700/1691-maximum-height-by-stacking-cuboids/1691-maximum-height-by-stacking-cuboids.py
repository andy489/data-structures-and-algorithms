# https://leetcode.com/problems/maximum-height-by-stacking-cuboids/

class Solution:
    def maxHeight(self, cuboids: list[list[int]]) -> int:
        for c in cuboids:
            c.sort()
        cuboids.sort()
        n = len(cuboids)
        dp = [c[2] for c in cuboids]
        for i in range(n):
            for j in range(i):
                if all(cuboids[j][d] <= cuboids[i][d] for d in range(3)):
                    dp[i] = max(dp[i], dp[j] + cuboids[i][2])
        return max(dp)
