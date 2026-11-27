# https://leetcode.com/problems/complete-binary-tree-inserter/

from collections import deque

class CBTInserter:
    def __init__(self, root):
        self.root = root
        self.candidates = deque()
        q = deque([root])
        while q:
            node = q.popleft()
            if node.left is None or node.right is None:
                self.candidates.append(node)
            if node.left:
                q.append(node.left)
            if node.right:
                q.append(node.right)

    def insert(self, val: int) -> int:
        node = type(self.root)(val)
        parent = self.candidates[0]
        if parent.left is None:
            parent.left = node
        else:
            parent.right = node
            self.candidates.popleft()
        self.candidates.append(node)
        return parent.val

    def get_root(self):
        return self.root
