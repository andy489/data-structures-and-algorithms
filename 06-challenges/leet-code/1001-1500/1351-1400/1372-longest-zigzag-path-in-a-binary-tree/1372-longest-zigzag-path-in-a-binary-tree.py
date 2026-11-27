# https://leetcode.com/problems/longest-zigzag-path-in-a-binary-tree/

class Solution:
    def longestZigZag(self, root) -> int:
        self.ans = 0
        def dfs(node, go_left, length):
            if not node:
                return
            self.ans = max(self.ans, length)
            if go_left:
                dfs(node.left, False, length+1)
                dfs(node.right, True, 1)
            else:
                dfs(node.right, True, length+1)
                dfs(node.left, False, 1)
        dfs(root, True, 0)
        dfs(root, False, 0)
        return self.ans
