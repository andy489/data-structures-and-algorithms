# https://leetcode.com/problems/longest-univalue-path/

class Solution:
    def longestUnivaluePath(self, root) -> int:
        self.max_path = 0

        def dfs(node):
            if not node:
                return 0
            left_arm = dfs(node.left)
            right_arm = dfs(node.right)
            left = (left_arm + 1) if node.left and node.left.val == node.val else 0
            right = (right_arm + 1) if node.right and node.right.val == node.val else 0
            self.max_path = max(self.max_path, left + right)
            return max(left, right)

        dfs(root)
        return self.max_path
