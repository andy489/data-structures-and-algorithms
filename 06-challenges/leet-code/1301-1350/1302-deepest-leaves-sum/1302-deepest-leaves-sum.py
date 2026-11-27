# https://leetcode.com/problems/deepest-leaves-sum/

from collections import deque

class Solution:
    def deepestLeavesSum(self, root) -> int:
        q = deque([root])
        total = 0
        while q:
            total = sum(node.val for node in q)
            q = deque(child for node in q for child in [node.left, node.right] if child)
        return total
