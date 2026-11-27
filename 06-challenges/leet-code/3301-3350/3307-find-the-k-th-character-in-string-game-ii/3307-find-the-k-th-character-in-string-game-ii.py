# https://leetcode.com/problems/find-the-k-th-character-in-string-game-ii/

from typing import List


class Solution:
    def kthCharacter(self, k: int, operations: List[int]) -> str:
        n = len(operations)
        sizes = [0] * (n + 1)
        sizes[0] = 1
        for i in range(n):
            sizes[i + 1] = min(sizes[i] * 2, 2 * 10**15)
        shift = 0
        for i in range(n - 1, -1, -1):
            half = sizes[i]
            if k > half:
                k -= half
                if operations[i] == 1:
                    shift += 1
        return chr(ord('a') + shift % 26)
