# https://leetcode.com/problems/combinations/

class Solution:
    def combine(self, n: int, k: int) -> list[list[int]]:
        result = []

        def backtrack(start, current):
            if len(current) == k:
                result.append(current[:])
                return
            need = k - len(current)
            for i in range(start, n - need + 2):
                current.append(i)
                backtrack(i + 1, current)
                current.pop()

        backtrack(1, [])
        return result
