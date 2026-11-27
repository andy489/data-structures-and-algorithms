# https://leetcode.com/problems/count-complete-tree-nodes/

class Solution:
    def countNodes(self, root: 'TreeNode | None') -> int:
        if not root:
            return 0
        lh = rh = 0
        node = root
        while node:
            lh += 1
            node = node.left
        node = root
        while node:
            rh += 1
            node = node.right
        if lh == rh:
            return (1 << lh) - 1
        return 1 + self.countNodes(root.left) + self.countNodes(root.right)
