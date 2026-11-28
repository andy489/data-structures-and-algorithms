# https://leetcode.com/problems/maximum-score-after-applying-operations-on-a-tree/

from collections import defaultdict

class Solution:
    def maximumScoreAfterOperations(self, edges: list[list[int]], values: list[int]) -> int:
        adj = defaultdict(list)
        for u, v in edges:
            adj[u].append(v)
            adj[v].append(u)

        def dfs(node: int, parent: int) -> int:
            child_keep = 0
            is_leaf = True
            for child in adj[node]:
                if child == parent:
                    continue
                is_leaf = False
                child_keep += dfs(child, node)
            if is_leaf:
                return values[node]
            return min(values[node], child_keep)

        return sum(values) - dfs(0, -1)
