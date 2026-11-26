# https://leetcode.com/problems/circular-permutation-in-binary-representation/

class Solution:
    def circularPermutation(self, n: int, start: int) -> list[int]:
        return [start ^ (i ^ (i >> 1)) for i in range(1 << n)]
