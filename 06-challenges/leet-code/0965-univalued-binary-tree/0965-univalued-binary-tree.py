# https://leetcode.com/problems/univalued-binary-tree/

class Solution:
    def isUnivalTree(self, root) -> bool:
        def check(node):
            if not node:
                return True
            if node.val != root.val:
                return False
            return check(node.left) and check(node.right)
        return check(root)
