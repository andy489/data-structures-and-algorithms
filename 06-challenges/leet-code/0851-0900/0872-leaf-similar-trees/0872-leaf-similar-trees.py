# https://leetcode.com/problems/leaf-similar-trees/

class Solution:
    def leafSimilar(self, root1, root2) -> bool:
        def leaves(node):
            if not node:
                return []
            if not node.left and not node.right:
                return [node.val]
            return leaves(node.left) + leaves(node.right)
        return leaves(root1) == leaves(root2)
