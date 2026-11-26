# https://leetcode.com/problems/even-odd-tree/

from collections import deque

class Solution:
    def isEvenOddTree(self, root) -> bool:
        queue = deque([root])
        even_level = True
        while queue:
            prev = float('-inf') if even_level else float('inf')
            for _ in range(len(queue)):
                node = queue.popleft()
                val = node.val
                if even_level and (val % 2 == 0 or val <= prev):
                    return False
                if not even_level and (val % 2 != 0 or val >= prev):
                    return False
                prev = val
                if node.left:
                    queue.append(node.left)
                if node.right:
                    queue.append(node.right)
            even_level = not even_level
        return True
