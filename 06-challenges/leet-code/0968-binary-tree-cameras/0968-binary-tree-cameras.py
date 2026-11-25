# https://leetcode.com/problems/binary-tree-cameras/

class Solution:
    def minCameraCover(self, root) -> int:
        self.cameras = 0

        def dfs(node):
            if not node:
                return 1
            left, right = dfs(node.left), dfs(node.right)
            if left == 0 or right == 0:
                self.cameras += 1
                return 2
            if left == 2 or right == 2:
                return 1
            return 0

        if dfs(root) == 0:
            self.cameras += 1
        return self.cameras
