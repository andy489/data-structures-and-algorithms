# https://leetcode.com/problems/binary-search-tree-to-greater-sum-tree/

class Solution:
    def bstToGst(self, root) -> 'TreeNode':
        self.total = 0
        def dfs(node):
            if node:
                dfs(node.right)
                self.total += node.val
                node.val = self.total
                dfs(node.left)
        dfs(root)
        return root
