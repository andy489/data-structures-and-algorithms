# https://leetcode.com/problems/maximum-points-after-collecting-coins-from-all-nodes/

from functools import lru_cache

class Solution:
    def maximumPoints(self, edges: list[list[int]], coins: list[int], k: int) -> int:
        n = len(coins)
        adj = [[] for _ in range(n)]
        for a, b in edges:
            adj[a].append(b)
            adj[b].append(a)

        @lru_cache(maxsize=None)
        def dfs(node, parent, halvings):
            if halvings >= 14:
                return 0
            v = coins[node] >> halvings
            opt1 = v - k
            opt2 = v >> 1
            for child in adj[node]:
                if child == parent:
                    continue
                opt1 += dfs(child, node, halvings)
                opt2 += dfs(child, node, halvings + 1)
            return max(opt1, opt2)

        return dfs(0, -1, 0)
