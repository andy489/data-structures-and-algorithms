# https://leetcode.com/problems/binary-tree-postorder-traversal/

class Solution:
    def postorderTraversal(self, root) -> list[int]:
        result = []
        if not root:
            return result
        stack = [root]
        while stack:
            node = stack.pop()
            result.append(node.val)
            if node.left:
                stack.append(node.left)
            if node.right:
                stack.append(node.right)
        result.reverse()
        return result


class Solution2:
    def postorderTraversal(self, root) -> list[int]:
        result = []

        def dfs(node):
            if not node:
                return
            dfs(node.left)
            dfs(node.right)
            result.append(node.val)

        dfs(root)
        return result


class Solution3:
    def postorderTraversal(self, root) -> list[int]:
        result = []
        if not root:
            return result
        stack, out = [root], []
        while stack:
            node = stack.pop()
            out.append(node)
            if node.left:
                stack.append(node.left)
            if node.right:
                stack.append(node.right)
        while out:
            result.append(out.pop().val)
        return result


class Solution4:
    def postorderTraversal(self, root) -> list[int]:
        result = []

        def add_reversed(frm, to):
            self._reverse(frm, to)
            node = to
            while True:
                result.append(node.val)
                if node is frm:
                    break
                node = node.right
            self._reverse(to, frm)

        dummy = type('Node', (), {'val': 0, 'left': root, 'right': None})()
        curr = dummy
        while curr:
            if not curr.left:
                curr = curr.right
            else:
                pred = curr.left
                while pred.right and pred.right is not curr:
                    pred = pred.right
                if not pred.right:
                    pred.right = curr
                    curr = curr.left
                else:
                    add_reversed(curr.left, pred)
                    pred.right = None
                    curr = curr.right
        return result

    def _reverse(self, frm, to):
        if frm is to:
            return
        prev, curr = frm, frm.right
        while prev is not to:
            nxt = curr.right
            curr.right = prev
            prev = curr
            curr = nxt
