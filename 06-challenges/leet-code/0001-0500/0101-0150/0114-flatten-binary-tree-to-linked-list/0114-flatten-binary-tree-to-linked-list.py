# https://leetcode.com/problems/flatten-binary-tree-to-linked-list/

# Solution 1: Post-order Recursion — O(n) time, O(h) space
class Solution:
    def flatten(self, root) -> None:
        if not root or (not root.left and not root.right):
            return
        self.flatten(root.left)
        self.flatten(root.right)
        right = root.right
        root.right = root.left
        root.left = None
        tail = root
        while tail.right:
            tail = tail.right
        tail.right = right


# Solution 2: Morris-like In-place — O(n) time, O(1) space
class Solution2:
    def flatten(self, root) -> None:
        curr = root
        while curr:
            if curr.left:
                pred = curr.left
                while pred.right:
                    pred = pred.right
                pred.right = curr.right
                curr.right = curr.left
                curr.left = None
            curr = curr.right


# Solution 3: Explicit Stack (Iterative Pre-order) — O(n) time, O(h) space
class Solution3:
    def flatten(self, root) -> None:
        if not root:
            return
        stack = [root]
        prev = None
        while stack:
            curr = stack.pop()
            if prev:
                prev.right = curr
                prev.left = None
            if curr.right:
                stack.append(curr.right)
            if curr.left:
                stack.append(curr.left)
            prev = curr
        prev.left = None
