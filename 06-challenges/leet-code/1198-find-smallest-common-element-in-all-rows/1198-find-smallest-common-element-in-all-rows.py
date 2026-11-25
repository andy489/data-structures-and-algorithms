# https://leetcode.com/problems/find-smallest-common-element-in-all-rows/

class Solution:
    def smallestCommonElement(self, mat: list[list[int]]) -> int:
        from collections import Counter
        count = Counter()
        for row in mat:
            for v in row:
                count[v] += 1
        m = len(mat)
        for v in mat[0]:
            if count[v] == m:
                return v
        return -1
