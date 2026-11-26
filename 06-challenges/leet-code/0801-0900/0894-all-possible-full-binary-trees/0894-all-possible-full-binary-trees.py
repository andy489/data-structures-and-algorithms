# https://leetcode.com/problems/all-possible-full-binary-trees/

from functools import lru_cache

class Solution:
    def allPossibleFBT(self, n: int) -> list['TreeNode']:
        @lru_cache(None)
        def build(n):
            if n == 1:
                return [TreeNode(0)]
            if n % 2 == 0:
                return []
            result = []
            for L in range(1, n, 2):
                for left in build(L):
                    for right in build(n - 1 - L):
                        result.append(TreeNode(0, left, right))
            return result
        return build(n)
