# https://leetcode.com/problems/find-bottom-left-tree-value/

from collections import deque

class Solution:
    def findBottomLeftValue(self, root) -> int:
        queue = deque([root])
        last = root
        while queue:
            last = queue.popleft()
            if last.right:
                queue.append(last.right)
            if last.left:
                queue.append(last.left)
        return last.val
