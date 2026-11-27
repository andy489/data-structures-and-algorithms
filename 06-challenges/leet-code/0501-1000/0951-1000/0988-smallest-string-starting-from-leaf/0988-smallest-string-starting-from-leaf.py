# https://leetcode.com/problems/smallest-string-starting-from-leaf/

class Solution:
    def smallestFromLeaf(self, root) -> str:
        self.ans = None

        def dfs(node, path):
            if not node:
                return
            path.append(chr(ord('a') + node.val))
            if not node.left and not node.right:
                s = ''.join(reversed(path))
                if self.ans is None or s < self.ans:
                    self.ans = s
            else:
                dfs(node.left, path)
                dfs(node.right, path)
            path.pop()

        dfs(root, [])
        return self.ans
