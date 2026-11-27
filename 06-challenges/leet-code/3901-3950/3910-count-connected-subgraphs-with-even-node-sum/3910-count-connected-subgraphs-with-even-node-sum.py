# https://leetcode.com/problems/count-connected-subgraphs-with-even-node-sum/
from typing import List


class Solution:
    def countSubgraphs(self, nums: List[int], edges: List[List[int]]) -> int:
        n = len(nums)
        adj = [0] * n
        for u, v in edges:
            adj[u] |= (1 << v)
            adj[v] |= (1 << u)

        def is_connected(mask: int) -> bool:
            start = (mask & -mask).bit_length() - 1
            visited = 1 << start
            queue = visited
            while queue:
                node = (queue & -queue).bit_length() - 1
                queue &= ~(1 << node)
                neighbors = adj[node] & mask & ~visited
                visited |= neighbors
                queue |= neighbors
            return visited == mask

        count = 0
        for mask in range(1, 1 << n):
            s = 0
            for i in range(n):
                if mask & (1 << i):
                    s += nums[i]
            if s % 2 == 0 and is_connected(mask):
                count += 1
        return count
