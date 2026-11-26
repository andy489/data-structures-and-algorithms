# https://leetcode.com/problems/final-value-of-variable-after-performing-operations/

class Solution:
    def finalValueAfterOperations(self, operations: list[str]) -> int:
        return sum(1 if '+' in op else -1 for op in operations)
