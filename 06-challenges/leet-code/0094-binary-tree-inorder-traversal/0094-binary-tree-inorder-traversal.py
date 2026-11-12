# https://leetcode.com/problems/binary-tree-inorder-traversal/

from typing import Optional

# Solution: Iterative with explicit stack — O(n) time, O(n) space
class Solution:
    def inorderTraversal(self, root: Optional['TreeNode']) -> list[int]:
        res, stack, curr = [], [], root
        while curr or stack:
            while curr:
                stack.append(curr)
                curr = curr.left
            curr = stack.pop()
            res.append(curr.val)
            curr = curr.right
        return res


# Solution 2: Recursive — O(n) time, O(n) space
class Solution2:
    def inorderTraversal(self, root: Optional['TreeNode']) -> list[int]:
        res = []
        def dfs(node):
            if not node:
                return
            dfs(node.left)
            res.append(node.val)
            dfs(node.right)
        dfs(root)
        return res
