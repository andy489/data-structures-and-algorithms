# https://leetcode.com/problems/check-completeness-of-a-binary-tree/

from collections import deque

class Solution:
    def isCompleteTree(self, root) -> bool:
        queue = deque([root])
        seen_null = False
        while queue:
            node = queue.popleft()
            if node is None:
                seen_null = True
            else:
                if seen_null:
                    return False
                queue.append(node.left)
                queue.append(node.right)
        return True
