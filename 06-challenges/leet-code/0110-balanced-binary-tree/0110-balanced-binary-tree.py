# https://leetcode.com/problems/balanced-binary-tree/

class Solution:
    def isBalanced(self, root) -> bool:
        def height(node):
            if not node:
                return 0
            lh = height(node.left)
            if lh == -1:
                return -1
            rh = height(node.right)
            if rh == -1:
                return -1
            if abs(lh - rh) > 1:
                return -1
            return max(lh, rh) + 1

        return height(root) != -1


class Solution2:
    def isBalanced(self, root) -> bool:
        if not root:
            return True
        lh = self._height(root.left)
        rh = self._height(root.right)
        return (abs(lh - rh) <= 1
                and self.isBalanced(root.left)
                and self.isBalanced(root.right))

    def _height(self, node):
        if not node:
            return 0
        return max(self._height(node.left), self._height(node.right)) + 1


class Solution3:
    def isBalanced(self, root) -> bool:
        if not root:
            return True
        heights = {}
        stack, prev, cur = [], None, root
        while cur or stack:
            while cur:
                stack.append(cur)
                cur = cur.left
            cur = stack[-1]
            if not cur.right or cur.right is prev:
                stack.pop()
                lh = heights.get(cur.left, 0)
                rh = heights.get(cur.right, 0)
                if abs(lh - rh) > 1:
                    return False
                heights[cur] = max(lh, rh) + 1
                prev, cur = cur, None
            else:
                cur = cur.right
        return True
