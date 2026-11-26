# https://leetcode.com/problems/path-sum-ii/

class Solution:
    def pathSum(self, root, targetSum: int) -> list[list[int]]:
        result = []

        def dfs(node, remaining, path):
            if not node:
                return
            path.append(node.val)
            remaining -= node.val
            if not node.left and not node.right and remaining == 0:
                result.append(list(path))
            dfs(node.left,  remaining, path)
            dfs(node.right, remaining, path)
            path.pop()

        dfs(root, targetSum, [])
        return result


class Solution2:
    def pathSum(self, root, targetSum: int) -> list[list[int]]:
        if not root:
            return []
        result = []
        stack = [(root, targetSum - root.val, [root.val])]
        while stack:
            node, remaining, path = stack.pop()
            if not node.left and not node.right and remaining == 0:
                result.append(path)
            for child in (node.right, node.left):
                if child:
                    stack.append((child, remaining - child.val, path + [child.val]))
        return result
