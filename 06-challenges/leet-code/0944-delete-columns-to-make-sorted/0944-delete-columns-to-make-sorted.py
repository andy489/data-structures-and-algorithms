# https://leetcode.com/problems/delete-columns-to-make-sorted/

class Solution:
    def minDeletionSize(self, strs: list) -> int:
        return sum(
            any(strs[i][j] < strs[i-1][j] for i in range(1, len(strs)))
            for j in range(len(strs[0]))
        )
