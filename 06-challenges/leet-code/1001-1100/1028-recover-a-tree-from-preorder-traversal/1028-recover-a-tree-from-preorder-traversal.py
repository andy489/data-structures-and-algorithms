# https://leetcode.com/problems/recover-a-tree-from-preorder-traversal/

class Solution:
    def recoverFromPreorder(self, traversal: str) -> 'TreeNode':
        stack = []
        i = 0
        while i < len(traversal):
            depth = 0
            while i < len(traversal) and traversal[i] == '-':
                depth += 1; i += 1
            val = 0
            while i < len(traversal) and traversal[i] != '-':
                val = val * 10 + int(traversal[i]); i += 1
            node = TreeNode(val)
            while len(stack) > depth:
                stack.pop()
            if stack:
                if not stack[-1].left:
                    stack[-1].left = node
                else:
                    stack[-1].right = node
            stack.append(node)
        return stack[0]
