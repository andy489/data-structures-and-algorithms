# https://leetcode.com/problems/insufficient-nodes-in-root-to-leaf-paths/

class Solution:
    def sufficientSubset(self, root, limit: int):
        if not root:
            return None
        if not root.left and not root.right:
            return None if root.val < limit else root
        root.left = self.sufficientSubset(root.left, limit - root.val)
        root.right = self.sufficientSubset(root.right, limit - root.val)
        return root if root.left or root.right else None
