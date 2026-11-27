# https://leetcode.com/problems/convert-1d-array-into-2d-array/

class Solution:
    def construct2DArray(self, original: list[int], m: int, n: int) -> list[list[int]]:
        if len(original) != m * n:
            return []
        return [original[i*n:(i+1)*n] for i in range(m)]
