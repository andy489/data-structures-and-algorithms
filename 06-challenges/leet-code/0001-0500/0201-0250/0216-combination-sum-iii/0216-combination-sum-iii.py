# https://leetcode.com/problems/combination-sum-iii/

class Solution:
    def combinationSum3(self, k: int, n: int) -> list[list[int]]:
        result: list[list[int]] = []

        def backtrack(start: int, remaining: int, path: list[int]) -> None:
            if len(path) == k:
                if remaining == 0:
                    result.append(path[:])
                return
            for i in range(start, 10):
                if i > remaining:
                    break
                path.append(i)
                backtrack(i + 1, remaining - i, path)
                path.pop()

        backtrack(1, n, [])
        return result
