# https://leetcode.com/problems/binary-tree-right-side-view/

from collections import deque

# Solution 1: BFS (level-order) — O(n) time, O(n) space
class Solution:
    def rightSideView(self, root: 'Optional[TreeNode]') -> list[int]:
        if not root:
            return []
        res = []
        q = deque([root])
        while q:
            size = len(q)
            for i in range(size):
                node = q.popleft()
                if node.left:
                    q.append(node.left)
                if node.right:
                    q.append(node.right)
            res.append(node.val)
        return res


# Solution 2: DFS (right-first preorder) — O(n) time, O(h) space
class Solution2:
    def rightSideView(self, root: 'Optional[TreeNode]') -> list[int]:
        res = []
        def dfs(node, depth):
            if not node:
                return
            if len(res) == depth:
                res.append(node.val)
            dfs(node.right, depth + 1)
            dfs(node.left, depth + 1)
        dfs(root, 0)
        return res
