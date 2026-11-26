# https://leetcode.com/problems/delete-columns-to-make-sorted-ii/

class Solution:
    def minDeletionSize(self, strs: list[str]) -> int:
        n, m = len(strs), len(strs[0])
        sorted_pairs = [False] * (n - 1)
        deleted = 0
        for j in range(m):
            if any(not sorted_pairs[i] and strs[i][j] > strs[i + 1][j] for i in range(n - 1)):
                deleted += 1
            else:
                for i in range(n - 1):
                    if strs[i][j] < strs[i + 1][j]:
                        sorted_pairs[i] = True
        return deleted
