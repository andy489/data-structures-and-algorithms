# https://leetcode.com/problems/matrix-similarity-after-cyclic-shifts/

class Solution:
    def areSimilar(self, mat: list[list[int]], k: int) -> bool:
        n = len(mat[0])
        shift = k % n
        if shift == 0:
            return True
        for row in mat:
            if len(set(row)) > 1:
                return False
        return True
