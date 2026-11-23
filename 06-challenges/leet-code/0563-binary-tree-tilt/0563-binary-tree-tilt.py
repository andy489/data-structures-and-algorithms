from typing import Optional


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def findTilt(self, root: Optional[TreeNode]) -> int:
        self.total = 0

        def subtree_sum(node):
            if not node:
                return 0
            left = subtree_sum(node.left)
            right = subtree_sum(node.right)
            self.total += abs(left - right)
            return node.val + left + right

        subtree_sum(root)
        return self.total
