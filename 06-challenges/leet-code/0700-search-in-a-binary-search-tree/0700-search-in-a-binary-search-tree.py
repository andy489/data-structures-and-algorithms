# https://leetcode.com/problems/search-in-a-binary-search-tree/

class Solution:
    def searchBST(self, root, val: int):
        while root:
            if root.val == val:
                return root
            elif val < root.val:
                root = root.left
            else:
                root = root.right
        return None
