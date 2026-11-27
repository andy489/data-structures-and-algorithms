# https://leetcode.com/problems/cousins-in-binary-tree/

from collections import deque

class Solution:
    def isCousins(self, root, x: int, y: int) -> bool:
        queue = deque([(root, None, 0)])
        x_info = y_info = None
        while queue:
            node, parent, depth = queue.popleft()
            if node.val == x:
                x_info = (depth, parent)
            if node.val == y:
                y_info = (depth, parent)
            if node.left:
                queue.append((node.left, node.val, depth + 1))
            if node.right:
                queue.append((node.right, node.val, depth + 1))
        return x_info[0] == y_info[0] and x_info[1] != y_info[1]
