# https://leetcode.com/problems/maximum-binary-tree-ii/

class Solution:
    def insertIntoMaxTree(self, root, val: int):
        from typing import Optional
        node = type(root)(val)
        if not root or root.val < val:
            node.left = root
            return node
        cur = root
        while cur.right and cur.right.val > val:
            cur = cur.right
        node.left = cur.right
        cur.right = node
        return root
