# https://leetcode.com/problems/print-binary-tree/

class Solution:
    def printTree(self, root) -> list:
        def height(node):
            if not node:
                return -1
            return 1 + max(height(node.left), height(node.right))

        h = height(root)
        cols = (1 << (h + 1)) - 1
        res = [[""] * cols for _ in range(h + 1)]

        def fill(node, row, col):
            if not node:
                return
            res[row][col] = str(node.val)
            offset = 1 << (h - row - 1)
            fill(node.left, row + 1, col - offset)
            fill(node.right, row + 1, col + offset)

        fill(root, 0, (cols - 1) // 2)
        return res
