# https://leetcode.com/problems/maximum-building-height/

class Solution:
    def maxBuilding(self, n: int, restrictions: list[list[int]]) -> int:
        r = [[1, 0]] + restrictions + [[n, n - 1]]
        r.sort()
        for i in range(1, len(r)):
            r[i][1] = min(r[i][1], r[i - 1][1] + r[i][0] - r[i - 1][0])
        for i in range(len(r) - 2, -1, -1):
            r[i][1] = min(r[i][1], r[i + 1][1] + r[i + 1][0] - r[i][0])
        ans = 0
        for i in range(1, len(r)):
            a, ha = r[i - 1]
            b, hb = r[i]
            ans = max(ans, (ha + hb + b - a) // 2)
        return ans
