# https://leetcode.com/problems/binary-tree-preorder-traversal/

class Solution:
    def preorderTraversal(self, root) -> list[int]:
        result = []
        if not root:
            return result
        stack = [root]
        while stack:
            node = stack.pop()
            result.append(node.val)
            if node.right:
                stack.append(node.right)
            if node.left:
                stack.append(node.left)
        return result


class Solution2:
    def preorderTraversal(self, root) -> list[int]:
        result = []

        def dfs(node):
            if not node:
                return
            result.append(node.val)
            dfs(node.left)
            dfs(node.right)

        dfs(root)
        return result


class Solution3:
    def preorderTraversal(self, root) -> list[int]:
        result = []
        curr = root
        while curr:
            if not curr.left:
                result.append(curr.val)
                curr = curr.right
            else:
                pred = curr.left
                while pred.right and pred.right is not curr:
                    pred = pred.right
                if not pred.right:
                    result.append(curr.val)
                    pred.right = curr
                    curr = curr.left
                else:
                    pred.right = None
                    curr = curr.right
        return result
