# https://leetcode.com/problems/binary-tree-coloring-game/

class Solution:
    def btreeGameWinningMove(self, root, n: int, x: int) -> bool:
        self.left = self.right = 0

        def count(node):
            if not node:
                return 0
            l, r = count(node.left), count(node.right)
            if node.val == x:
                self.left, self.right = l, r
            return l + r + 1

        count(root)
        parent = n - self.left - self.right - 1
        return max(self.left, self.right, parent) > n // 2
