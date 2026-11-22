# https://leetcode.com/problems/different-ways-to-add-parentheses/

from functools import lru_cache

class Solution:
    def diffWaysToCompute(self, expression: str) -> list[int]:
        @lru_cache(maxsize=None)
        def solve(expr: str) -> list[int]:
            result: list[int] = []
            for i, c in enumerate(expr):
                if c in '+-*':
                    for l in solve(expr[:i]):
                        for r in solve(expr[i + 1:]):
                            if c == '+':
                                result.append(l + r)
                            elif c == '-':
                                result.append(l - r)
                            else:
                                result.append(l * r)
            if not result:
                result.append(int(expr))
            return result

        return solve(expression)
