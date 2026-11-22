# https://leetcode.com/problems/invert-binary-tree/

class Solution:
    def invertTree(self, root: 'TreeNode | None') -> 'TreeNode | None':
        if not root:
            return None
        root.left, root.right = root.right, root.left
        self.invertTree(root.left)
        self.invertTree(root.right)
        return root


from collections import deque

class Solution2:
    def invertTree(self, root: 'TreeNode | None') -> 'TreeNode | None':
        if not root:
            return None
        queue: deque['TreeNode'] = deque([root])
        while queue:
            node = queue.popleft()
            node.left, node.right = node.right, node.left
            if node.left:
                queue.append(node.left)
            if node.right:
                queue.append(node.right)
        return root
