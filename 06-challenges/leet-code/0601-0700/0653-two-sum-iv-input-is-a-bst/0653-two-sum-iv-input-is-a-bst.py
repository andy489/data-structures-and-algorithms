# https://leetcode.com/problems/two-sum-iv-input-is-a-bst/

class Solution:
    def findTarget(self, root, k: int) -> bool:
        seen = set()

        def dfs(node):
            if not node:
                return False
            if k - node.val in seen:
                return True
            seen.add(node.val)
            return dfs(node.left) or dfs(node.right)

        return dfs(root)
