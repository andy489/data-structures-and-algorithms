# https://leetcode.com/problems/maximum-depth-of-n-ary-tree/
# Solution: DFS — O(n) time, O(h) space
class Solution:
    def maxDepth(self, root) -> int:
        if not root:
            return 0
        if not root.children:
            return 1
        return 1 + max(self.maxDepth(child) for child in root.children)
