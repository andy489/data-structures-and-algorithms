# https://leetcode.com/problems/kth-smallest-element-in-a-bst/

class Solution:
    def kthSmallest(self, root: 'TreeNode | None', k: int) -> int:
        stack: list['TreeNode'] = []
        curr = root
        while curr or stack:
            while curr:
                stack.append(curr)
                curr = curr.left
            curr = stack.pop()
            k -= 1
            if k == 0:
                return curr.val
            curr = curr.right
        return -1


class Solution2:
    def kthSmallest(self, root: 'TreeNode | None', k: int) -> int:
        self._k = k
        self._result = -1

        def inorder(node: 'TreeNode | None') -> None:
            if not node or self._k <= 0:
                return
            inorder(node.left)
            self._k -= 1
            if self._k == 0:
                self._result = node.val
            inorder(node.right)

        inorder(root)
        return self._result
