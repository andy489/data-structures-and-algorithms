# https://leetcode.com/problems/add-one-row-to-tree/

from collections import deque

class Solution:
    def addOneRow(self, root, val: int, depth: int):
        if depth == 1:
            new_root = type(root)(val)
            new_root.left = root
            return new_root
        queue = deque([root])
        current_depth = 1
        while queue:
            if current_depth == depth - 1:
                for _ in range(len(queue)):
                    node = queue.popleft()
                    new_left = type(root)(val)
                    new_right = type(root)(val)
                    new_left.left = node.left
                    new_right.right = node.right
                    node.left = new_left
                    node.right = new_right
                break
            for _ in range(len(queue)):
                node = queue.popleft()
                if node.left:
                    queue.append(node.left)
                if node.right:
                    queue.append(node.right)
            current_depth += 1
        return root
