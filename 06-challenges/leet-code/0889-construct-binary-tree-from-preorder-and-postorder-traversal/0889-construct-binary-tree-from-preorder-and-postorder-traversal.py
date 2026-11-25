# https://leetcode.com/problems/construct-binary-tree-from-preorder-and-postorder-traversal/

class Solution:
    def constructFromPrePost(self, preorder: list[int], postorder: list[int]) -> 'TreeNode':
        if not preorder:
            return None
        root = TreeNode(preorder[0])
        if len(preorder) == 1:
            return root
        left_root = preorder[1]
        L = postorder.index(left_root) + 1
        root.left = self.constructFromPrePost(preorder[1:L+1], postorder[:L])
        root.right = self.constructFromPrePost(preorder[L+1:], postorder[L:-1])
        return root
