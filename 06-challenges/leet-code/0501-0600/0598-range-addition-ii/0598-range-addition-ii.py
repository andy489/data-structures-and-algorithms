# https://leetcode.com/problems/range-addition-ii/
class Solution:
    def maxCount(self, m: int, n: int, ops: List[List[int]]) -> int:
        if not ops:
            return m * n
        min_row = min(op[0] for op in ops)
        min_col = min(op[1] for op in ops)
        return min_row * min_col
