# https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/

from collections import deque

class Solution:
    def zigzagLevelOrder(self, root: Optional[TreeNode]) -> list[list[int]]:
        if not root:
            return []
        result, queue, left_to_right = [], deque([root]), True
        while queue:
            level = []
            for _ in range(len(queue)):
                node = queue.popleft()
                level.append(node.val)
                if node.left:
                    queue.append(node.left)
                if node.right:
                    queue.append(node.right)
            result.append(level if left_to_right else level[::-1])
            left_to_right = not left_to_right
        return result
