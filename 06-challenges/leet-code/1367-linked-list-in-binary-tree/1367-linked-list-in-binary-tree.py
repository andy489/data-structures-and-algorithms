# https://leetcode.com/problems/linked-list-in-binary-tree/

class Solution:
    def isSubPath(self, head, root) -> bool:
        def match(node, t_node):
            if not node:
                return True
            if not t_node or t_node.val != node.val:
                return False
            return match(node.next, t_node.left) or match(node.next, t_node.right)
        if not root:
            return False
        return match(head, root) or self.isSubPath(head, root.left) or self.isSubPath(head, root.right)
