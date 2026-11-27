# https://leetcode.com/problems/lowest-common-ancestor-of-deepest-leaves/

class Solution:
    def lcaDeepestLeaves(self, root):
        def dfs(node):
            if not node:
                return 0, None
            ld, ll = dfs(node.left)
            rd, rl = dfs(node.right)
            if ld == rd:
                return ld + 1, node
            return (ld + 1, ll) if ld > rd else (rd + 1, rl)

        return dfs(root)[1]
