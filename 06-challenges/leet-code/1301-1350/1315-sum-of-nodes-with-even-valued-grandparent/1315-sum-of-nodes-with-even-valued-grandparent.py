# https://leetcode.com/problems/sum-of-nodes-with-even-valued-grandparent/

class Solution:
    def sumEvenGrandparent(self, root) -> int:
        def dfs(node, parent, grandparent):
            if not node:
                return 0
            total = node.val if grandparent % 2 == 0 else 0
            return total + dfs(node.left, node.val, parent) + dfs(node.right, node.val, parent)
        return dfs(root, 1, 1)
