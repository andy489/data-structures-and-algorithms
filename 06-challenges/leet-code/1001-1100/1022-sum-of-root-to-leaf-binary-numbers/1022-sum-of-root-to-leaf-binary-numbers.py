# https://leetcode.com/problems/sum-of-root-to-leaf-binary-numbers/

class Solution:
    def sumRootToLeaf(self, root: 'TreeNode') -> int:
        def dfs(node, cur):
            if not node:
                return 0
            cur = cur * 2 + node.val
            if not node.left and not node.right:
                return cur
            return dfs(node.left, cur) + dfs(node.right, cur)
        return dfs(root, 0)
