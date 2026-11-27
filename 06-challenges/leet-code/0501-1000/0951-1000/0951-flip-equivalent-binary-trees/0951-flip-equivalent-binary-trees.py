# https://leetcode.com/problems/flip-equivalent-binary-trees/

class Solution:
    def flipEquiv(self, root1, root2) -> bool:
        if not root1 and not root2:
            return True
        if not root1 or not root2 or root1.val != root2.val:
            return False
        no_flip = self.flipEquiv(root1.left, root2.left) and self.flipEquiv(root1.right, root2.right)
        flip = self.flipEquiv(root1.left, root2.right) and self.flipEquiv(root1.right, root2.left)
        return no_flip or flip
