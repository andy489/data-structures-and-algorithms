# https://leetcode.com/problems/smallest-subtree-with-all-the-deepest-nodes/

class Solution:
    def subtreeWithAllDeepest(self, root) -> 'TreeNode':
        def dfs(node):
            if not node:
                return None, 0
            l_node, l_depth = dfs(node.left)
            r_node, r_depth = dfs(node.right)
            if l_depth == r_depth:
                return node, l_depth + 1
            elif l_depth > r_depth:
                return l_node, l_depth + 1
            else:
                return r_node, r_depth + 1
        return dfs(root)[0]
