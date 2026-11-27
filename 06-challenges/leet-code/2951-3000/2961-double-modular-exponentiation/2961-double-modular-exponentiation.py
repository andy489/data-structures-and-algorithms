# https://leetcode.com/problems/double-modular-exponentiation/
class Solution:
    def getGoodIndices(self, variables: list[list[int]], target: int) -> list[int]:
        result = []
        for i, (a, b, c, m) in enumerate(variables):
            inner = pow(a, b, 10)
            val = pow(inner, c, m)
            if val == target:
                result.append(i)
        return result
