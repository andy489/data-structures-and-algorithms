# https://leetcode.com/problems/diameter-of-binary-tree/
# Solution: DFS post-order — O(n) time, O(h) space
class Solution:
    def diameterOfBinaryTree(self, root) -> int:
        self.max_diameter = 0

        def depth(node):
            if not node:
                return 0
            left_depth = depth(node.left)
            right_depth = depth(node.right)
            self.max_diameter = max(self.max_diameter, left_depth + right_depth)
            return 1 + max(left_depth, right_depth)

        depth(root)
        return self.max_diameter
