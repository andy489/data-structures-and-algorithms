# https://leetcode.com/problems/minimum-time-to-collect-all-apples-in-a-tree/

class Solution:
    def minTime(self, n: int, edges: list[list[int]], hasApple: list[bool]) -> int:
        from collections import defaultdict
        adj = defaultdict(list)
        for u, v in edges:
            adj[u].append(v)
            adj[v].append(u)
        def dfs(u, parent):
            total = 0
            for v in adj[u]:
                if v == parent:
                    continue
                cost = dfs(v, u)
                if cost > 0 or hasApple[v]:
                    total += cost + 2
            return total
        return dfs(0, -1)
