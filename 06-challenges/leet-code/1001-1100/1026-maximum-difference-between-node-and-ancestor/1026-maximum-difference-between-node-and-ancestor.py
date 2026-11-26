# https://leetcode.com/problems/maximum-difference-between-node-and-ancestor/

class Solution:
    def maxAncestorDiff(self, root: 'TreeNode') -> int:
        def dfs(node, min_val, max_val):
            if not node:
                return max_val - min_val
            min_val = min(min_val, node.val)
            max_val = max(max_val, node.val)
            return max(dfs(node.left, min_val, max_val), dfs(node.right, min_val, max_val))
        return dfs(root, root.val, root.val)
