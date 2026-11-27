# https://leetcode.com/problems/flip-binary-tree-to-match-preorder-traversal/

class Solution:
    def flipMatchVoyage(self, root, voyage: list[int]) -> list[int]:
        res = []
        self.i = 0
        self.ok = True

        def dfs(node):
            if not node or not self.ok:
                return
            if node.val != voyage[self.i]:
                self.ok = False
                return
            self.i += 1
            if node.left and node.left.val != voyage[self.i]:
                res.append(node.val)
                dfs(node.right)
                dfs(node.left)
            else:
                dfs(node.left)
                dfs(node.right)

        dfs(root)
        return res if self.ok else [-1]
