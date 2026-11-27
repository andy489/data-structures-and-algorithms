# https://leetcode.com/problems/distribute-coins-in-binary-tree/

class Solution:
    def distributeCoins(self, root) -> int:
        self.moves = 0

        def dfs(node):
            if not node:
                return 0
            left, right = dfs(node.left), dfs(node.right)
            self.moves += abs(left) + abs(right)
            return node.val + left + right - 1

        dfs(root)
        return self.moves
