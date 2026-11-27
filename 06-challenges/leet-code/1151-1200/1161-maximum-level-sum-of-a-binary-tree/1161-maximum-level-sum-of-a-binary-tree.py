# https://leetcode.com/problems/maximum-level-sum-of-a-binary-tree/

from collections import deque

class Solution:
    def maxLevelSum(self, root) -> int:
        q = deque([root])
        best_level, best_sum = 1, float('-inf')
        level = 0
        while q:
            level += 1
            level_sum = 0
            for _ in range(len(q)):
                node = q.popleft()
                level_sum += node.val
                if node.left:
                    q.append(node.left)
                if node.right:
                    q.append(node.right)
            if level_sum > best_sum:
                best_sum = level_sum
                best_level = level
        return best_level
