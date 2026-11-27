# https://leetcode.com/problems/number-of-good-leaf-nodes-pairs/

class Solution:
    def countPairs(self, root, distance: int) -> int:
        result = [0]

        def dfs(node):
            if not node:
                return []
            if not node.left and not node.right:
                return [1]
            left = dfs(node.left)
            right = dfs(node.right)
            for l in left:
                for r in right:
                    if l + r <= distance:
                        result[0] += 1
            return [d + 1 for d in left + right if d + 1 <= distance]

        dfs(root)
        return result[0]
