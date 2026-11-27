# https://leetcode.com/problems/delete-leaves-with-a-given-value/

class Solution:
    def removeLeafNodes(self, root, target: int):
        if not root:
            return None
        root.left = self.removeLeafNodes(root.left, target)
        root.right = self.removeLeafNodes(root.right, target)
        return None if not root.left and not root.right and root.val == target else root
