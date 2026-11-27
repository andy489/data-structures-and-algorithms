# https://leetcode.com/problems/n-ary-tree-postorder-traversal/
class Solution:
    def postorder(self, root: 'Node') -> List[int]:
        result = []
        def dfs(node):
            if not node:
                return
            for child in node.children:
                dfs(child)
            result.append(node.val)
        dfs(root)
        return result
