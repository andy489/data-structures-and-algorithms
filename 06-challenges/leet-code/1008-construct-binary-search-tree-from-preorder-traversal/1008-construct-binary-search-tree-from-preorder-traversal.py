# https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/

class Solution:
    def bstFromPreorder(self, preorder: list[int]) -> 'TreeNode':
        self.i = 0
        def build(bound):
            if self.i == len(preorder) or preorder[self.i] > bound:
                return None
            node = TreeNode(preorder[self.i])
            self.i += 1
            node.left = build(node.val)
            node.right = build(bound)
            return node
        return build(float('inf'))
