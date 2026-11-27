# https://leetcode.com/problems/find-positive-integer-solution-for-a-given-equation/

class Solution:
    def findSolution(self, customfunction, z: int) -> list[list[int]]:
        res = []
        x, y = 1, 1000
        while x <= 1000 and y >= 1:
            v = customfunction.f(x, y)
            if v == z: res.append([x, y]); x += 1; y -= 1
            elif v < z: x += 1
            else: y -= 1
        return res
