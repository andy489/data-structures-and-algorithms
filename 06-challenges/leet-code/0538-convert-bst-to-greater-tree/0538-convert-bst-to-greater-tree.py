# https://leetcode.com/problems/convert-bst-to-greater-tree/

class Solution:
    def convertBST(self, root: Optional[TreeNode]) -> Optional[TreeNode]:
        self.running_sum = 0

        def reverse_inorder(node: Optional[TreeNode]) -> None:
            if not node:
                return
            reverse_inorder(node.right)
            self.running_sum += node.val
            node.val = self.running_sum
            reverse_inorder(node.left)

        reverse_inorder(root)
        return root
