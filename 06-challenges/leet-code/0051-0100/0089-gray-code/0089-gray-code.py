# https://leetcode.com/problems/gray-code/

class Solution:
    def grayCode(self, n: int) -> list[int]:
        return [i ^ (i >> 1) for i in range(1 << n)]


# Solution 2: Recursive Reflection — O(2^n) time, O(2^n) space
class Solution2:
    def grayCode(self, n: int) -> list[int]:
        code = [0, 1]
        for bit in range(1, n):
            code += [(1 << bit) | v for v in reversed(code)]
        return code
