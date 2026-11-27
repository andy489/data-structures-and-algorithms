# https://leetcode.com/problems/path-with-maximum-probability/

import heapq

class Solution:
    def maxProbability(self, n: int, edges, succProb, start: int, end: int) -> float:
        adj = [[] for _ in range(n)]
        for (u, v), p in zip(edges, succProb):
            adj[u].append((v, p))
            adj[v].append((u, p))
        prob = [0.0] * n
        prob[start] = 1.0
        heap = [(-1.0, start)]  # max-heap via negation
        while heap:
            neg_p, u = heapq.heappop(heap)
            p = -neg_p
            if p < prob[u]:
                continue
            if u == end:
                return p
            for v, ep in adj[u]:
                np = p * ep
                if np > prob[v]:
                    prob[v] = np
                    heapq.heappush(heap, (-np, v))
        return 0.0
