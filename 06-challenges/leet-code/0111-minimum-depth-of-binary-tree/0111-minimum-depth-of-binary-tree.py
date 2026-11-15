# https://leetcode.com/problems/minimum-depth-of-binary-tree/

from collections import deque

class Solution:
    def minDepth(self, root) -> int:
        if not root:
            return 0
        queue = deque([root])
        depth = 0
        while queue:
            depth += 1
            for _ in range(len(queue)):
                node = queue.popleft()
                if not node.left and not node.right:
                    return depth
                if node.left:
                    queue.append(node.left)
                if node.right:
                    queue.append(node.right)
        return depth


class Solution2:
    def minDepth(self, root) -> int:
        if not root:
            return 0
        if not root.left and not root.right:
            return 1
        if not root.left:
            return self.minDepth(root.right) + 1
        if not root.right:
            return self.minDepth(root.left) + 1
        return min(self.minDepth(root.left), self.minDepth(root.right)) + 1


class Solution3:
    def minDepth(self, root) -> int:
        if not root:
            return 0
        min_depth = float('inf')
        stack = [(root, 1)]
        while stack:
            node, depth = stack.pop()
            if not node.left and not node.right:
                min_depth = min(min_depth, depth)
            if node.right:
                stack.append((node.right, depth + 1))
            if node.left:
                stack.append((node.left, depth + 1))
        return min_depth


class Solution4:
    def minDepth(self, root) -> int:
        if not root:
            return 0
        self.min = float('inf')
        self._dfs(root, 1)
        return self.min

    def _dfs(self, node, depth):
        if not node.left and not node.right:
            self.min = min(self.min, depth)
            return
        if node.left:
            self._dfs(node.left, depth + 1)
        if node.right:
            self._dfs(node.right, depth + 1)
