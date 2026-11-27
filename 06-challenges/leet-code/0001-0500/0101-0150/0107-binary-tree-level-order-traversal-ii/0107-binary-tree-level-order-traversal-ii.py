# https://leetcode.com/problems/binary-tree-level-order-traversal-ii/

from collections import deque

class Solution:
    def levelOrderBottom(self, root):
        result = deque()
        if not root:
            return list(result)
        queue = deque([root])
        while queue:
            level = []
            for _ in range(len(queue)):
                node = queue.popleft()
                level.append(node.val)
                if node.left:
                    queue.append(node.left)
                if node.right:
                    queue.append(node.right)
            result.appendleft(level)
        return list(result)


class Solution2:
    def levelOrderBottom(self, root):
        result = []

        def dfs(node, depth):
            if not node:
                return
            if len(result) == depth:
                result.append([])
            result[depth].append(node.val)
            dfs(node.left, depth + 1)
            dfs(node.right, depth + 1)

        dfs(root, 0)
        return result[::-1]
