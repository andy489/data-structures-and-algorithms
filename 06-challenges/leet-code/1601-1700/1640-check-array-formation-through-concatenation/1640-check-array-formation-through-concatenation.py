# https://leetcode.com/problems/check-array-formation-through-concatenation/

class Solution:
    def canFormArray(self, arr: list[int], pieces: list[list[int]]) -> bool:
        by_first = {p[0]: p for p in pieces}
        i = 0
        while i < len(arr):
            piece = by_first.get(arr[i])
            if piece is None:
                return False
            for v in piece:
                if arr[i] != v:
                    return False
                i += 1
        return True
