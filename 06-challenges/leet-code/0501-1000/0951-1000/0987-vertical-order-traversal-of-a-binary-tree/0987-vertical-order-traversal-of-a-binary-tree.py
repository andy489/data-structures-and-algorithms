# https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/

class Solution:
    def verticalTraversal(self, root) -> list[list[int]]:
        nodes = []
        def dfs(node, col, row):
            if not node:
                return
            nodes.append((col, row, node.val))
            dfs(node.left, col - 1, row + 1)
            dfs(node.right, col + 1, row + 1)
        dfs(root, 0, 0)
        nodes.sort()
        res, prev_col = [], None
        for col, row, val in nodes:
            if col != prev_col:
                res.append([])
                prev_col = col
            res[-1].append(val)
        return res
