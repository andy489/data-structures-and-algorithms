# https://leetcode.com/problems/maximum-width-of-binary-tree/

from collections import deque

class Solution:
    def widthOfBinaryTree(self, root) -> int:
        max_width = 0
        queue = deque([(root, 0)])
        while queue:
            size = len(queue)
            first = queue[0][1]
            last = 0
            for _ in range(size):
                node, idx = queue.popleft()
                norm = idx - first
                last = idx
                if node.left:
                    queue.append((node.left, 2 * norm))
                if node.right:
                    queue.append((node.right, 2 * norm + 1))
            max_width = max(max_width, last - first + 1)
        return max_width
