# https://leetcode.com/problems/binary-tree-maximum-path-sum/

class Solution:
    def maxPathSum(self, root) -> int:
        self.ans = float('-inf')

        def dfs(node):
            if not node:
                return 0
            left_gain = max(0, dfs(node.left))
            right_gain = max(0, dfs(node.right))
            self.ans = max(self.ans, node.val + left_gain + right_gain)
            return node.val + max(left_gain, right_gain)

        dfs(root)
        return self.ans
