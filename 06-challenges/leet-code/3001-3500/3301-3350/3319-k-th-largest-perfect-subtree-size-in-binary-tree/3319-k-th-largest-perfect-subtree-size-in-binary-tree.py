# https://leetcode.com/problems/k-th-largest-perfect-subtree-size-in-binary-tree/

from typing import Optional


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def kthLargestPerfectSubtree(self, root: Optional[TreeNode], k: int) -> int:
        sizes = []

        def dfs(node):
            if node is None:
                return 0
            left = dfs(node.left)
            right = dfs(node.right)
            if left == -1 or right == -1 or left != right:
                return -1
            size = left + right + 1
            sizes.append(size)
            return size

        dfs(root)
        sizes.sort(reverse=True)
        return sizes[k - 1] if len(sizes) >= k else -1
