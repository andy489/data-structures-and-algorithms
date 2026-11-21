# https://leetcode.com/problems/binary-search-tree-iterator/

# Solution 1: Controlled stack — O(1) avg time, O(h) space
class BSTIterator:
    def __init__(self, root):
        self.stack = []
        self._push_left(root)

    def next(self) -> int:
        node = self.stack.pop()
        self._push_left(node.right)
        return node.val

    def hasNext(self) -> bool:
        return bool(self.stack)

    def _push_left(self, node) -> None:
        while node:
            self.stack.append(node)
            node = node.left


# Solution 2: Flattened list — O(n) init, O(1) per call, O(n) space
class BSTIterator2:
    def __init__(self, root):
        self.vals: list[int] = []
        self.idx = 0
        self._inorder(root)

    def next(self) -> int:
        val = self.vals[self.idx]
        self.idx += 1
        return val

    def hasNext(self) -> bool:
        return self.idx < len(self.vals)

    def _inorder(self, node) -> None:
        if node is None:
            return
        self._inorder(node.left)
        self.vals.append(node.val)
        self._inorder(node.right)
