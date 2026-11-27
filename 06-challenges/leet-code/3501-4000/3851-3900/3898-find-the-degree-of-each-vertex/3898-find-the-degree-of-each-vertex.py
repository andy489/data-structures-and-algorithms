# https://leetcode.com/problems/find-the-degree-of-each-vertex/
class Solution:
    def findDegree(self, matrix: list[list[int]]) -> list[int]:
        return [sum(row) for row in matrix]
