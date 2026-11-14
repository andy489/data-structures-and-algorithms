# https://leetcode.com/problems/symmetric-tree/

class Solution:
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        def is_mirror(left, right):
            if not left and not right:
                return True
            if not left or not right:
                return False
            return (left.val == right.val
                    and is_mirror(left.left, right.right)
                    and is_mirror(left.right, right.left))

        return is_mirror(root.left, root.right)
