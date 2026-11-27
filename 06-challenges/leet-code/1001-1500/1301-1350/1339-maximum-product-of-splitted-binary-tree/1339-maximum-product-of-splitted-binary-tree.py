# https://leetcode.com/problems/maximum-product-of-splitted-binary-tree/

class Solution:
    def maxProduct(self, root) -> int:
        def total(node):
            return 0 if not node else node.val + total(node.left) + total(node.right)
        t = total(root)
        self.best = 0
        def dfs(node):
            if not node:
                return 0
            s = node.val + dfs(node.left) + dfs(node.right)
            self.best = max(self.best, s * (t - s))
            return s
        dfs(root)
        return self.best % (10**9 + 7)
