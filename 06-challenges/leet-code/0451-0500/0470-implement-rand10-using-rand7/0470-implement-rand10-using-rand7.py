# https://leetcode.com/problems/implement-rand10-using-rand7/

class Solution(SolBase):
    def rand10(self) -> int:
        while True:
            row = self.rand7() - 1
            col = self.rand7() - 1
            idx = row * 7 + col
            if idx < 40:
                return idx % 10 + 1
