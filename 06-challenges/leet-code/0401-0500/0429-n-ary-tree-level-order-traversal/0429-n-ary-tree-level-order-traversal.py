# https://leetcode.com/problems/n-ary-tree-level-order-traversal/

from collections import deque

class Solution:
    def levelOrder(self, root: 'Node') -> list[list[int]]:
        if not root:
            return []
        levels = []
        queue = deque([root])
        while queue:
            level_size = len(queue)
            level_values = []
            for _ in range(level_size):
                node = queue.popleft()
                level_values.append(node.val)
                for child in node.children:
                    queue.append(child)
            levels.append(level_values)
        return levels
