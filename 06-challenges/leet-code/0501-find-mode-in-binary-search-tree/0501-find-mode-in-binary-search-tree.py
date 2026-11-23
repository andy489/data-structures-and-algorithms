# https://leetcode.com/problems/find-mode-in-binary-search-tree/

class Solution:
    def findMode(self, root) -> list[int]:
        modes = []
        max_count = cur_count = 0
        prev = None

        def inorder(node):
            nonlocal max_count, cur_count, prev
            if not node:
                return
            inorder(node.left)
            cur_count = cur_count + 1 if node.val == prev else 1
            if cur_count > max_count:
                max_count = cur_count
                modes.clear()
                modes.append(node.val)
            elif cur_count == max_count:
                modes.append(node.val)
            prev = node.val
            inorder(node.right)

        inorder(root)
        return modes
