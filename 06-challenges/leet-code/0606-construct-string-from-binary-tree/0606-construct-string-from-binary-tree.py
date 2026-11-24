# https://leetcode.com/problems/construct-string-from-binary-tree/

class Solution:
    def tree2str(self, root) -> str:
        if root is None:
            return ""
        result = str(root.val)
        if root.left or root.right:
            result += "(" + self.tree2str(root.left) + ")"
        if root.right:
            result += "(" + self.tree2str(root.right) + ")"
        return result
