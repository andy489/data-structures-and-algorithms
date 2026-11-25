# https://leetcode.com/problems/second-minimum-node-in-a-binary-tree/

class Solution:
    def findSecondMinimumValue(self, root) -> int:
        min_val = root.val
        result = [float('inf')]

        def dfs(node):
            if not node:
                return
            if node.val > min_val and node.val < result[0]:
                result[0] = node.val
                return
            dfs(node.left)
            dfs(node.right)

        dfs(root)
        return result[0] if result[0] != float('inf') else -1
