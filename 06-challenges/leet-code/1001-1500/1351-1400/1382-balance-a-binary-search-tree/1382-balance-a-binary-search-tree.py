# https://leetcode.com/problems/balance-a-binary-search-tree/

class Solution:
    def balanceBST(self, root):
        nodes = []
        def inorder(node):
            if not node:
                return
            inorder(node.left)
            nodes.append(node.val)
            inorder(node.right)
        inorder(root)
        def build(lo, hi):
            if lo > hi:
                return None
            mid = (lo + hi) // 2
            node = type(root)(nodes[mid])
            node.left = build(lo, mid-1)
            node.right = build(mid+1, hi)
            return node
        return build(0, len(nodes)-1)
