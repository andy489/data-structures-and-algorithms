# https://leetcode.com/problems/number-of-restricted-paths-from-first-to-last-node/

import heapq
from functools import lru_cache

class Solution:
    def countRestrictedPaths(self, n: int, edges: list[list[int]]) -> int:
        MOD = 10**9 + 7
        adj = [[] for _ in range(n + 1)]
        for u, v, w in edges:
            adj[u].append((v, w))
            adj[v].append((u, w))

        dist = [float('inf')] * (n + 1)
        dist[n] = 0
        pq = [(0, n)]
        while pq:
            d, u = heapq.heappop(pq)
            if d > dist[u]:
                continue
            for v, w in adj[u]:
                if dist[u] + w < dist[v]:
                    dist[v] = dist[u] + w
                    heapq.heappush(pq, (dist[v], v))

        @lru_cache(maxsize=None)
        def dp(u: int) -> int:
            if u == n:
                return 1
            result = 0
            for v, _ in adj[u]:
                if dist[v] < dist[u]:
                    result = (result + dp(v)) % MOD
            return result

        return dp(1)
