# https://leetcode.com/problems/n-ary-tree-preorder-traversal/
class Solution:
    def preorder(self, root: 'Node') -> List[int]:
        result = []
        def dfs(node):
            if not node:
                return
            result.append(node.val)
            for child in node.children:
                dfs(child)
        dfs(root)
        return result
