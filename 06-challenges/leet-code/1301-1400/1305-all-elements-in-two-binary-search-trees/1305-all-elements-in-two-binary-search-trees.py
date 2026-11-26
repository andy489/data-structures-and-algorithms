# https://leetcode.com/problems/all-elements-in-two-binary-search-trees/

import heapq

class Solution:
    def getAllElements(self, root1, root2) -> list[int]:
        def inorder(node):
            if not node:
                return []
            return inorder(node.left) + [node.val] + inorder(node.right)
        l1, l2 = inorder(root1), inorder(root2)
        res, i, j = [], 0, 0
        while i < len(l1) and j < len(l2):
            if l1[i] <= l2[j]:
                res.append(l1[i]); i += 1
            else:
                res.append(l2[j]); j += 1
        return res + l1[i:] + l2[j:]
