# https://leetcode.com/problems/binary-tree-pruning/

class Solution:
    def pruneTree(self, root):
        if not root:
            return None
        root.left = self.pruneTree(root.left)
        root.right = self.pruneTree(root.right)
        if root.val == 0 and not root.left and not root.right:
            return None
        return root
