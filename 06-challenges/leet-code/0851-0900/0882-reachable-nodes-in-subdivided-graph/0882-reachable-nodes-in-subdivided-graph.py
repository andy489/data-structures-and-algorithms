# https://leetcode.com/problems/reachable-nodes-in-subdivided-graph/

import heapq
from collections import defaultdict

class Solution:
    def reachableNodes(self, edges: list[list[int]], maxMoves: int, n: int) -> int:
        graph = defaultdict(list)
        for u, v, cnt in edges:
            graph[u].append((v, cnt))
            graph[v].append((u, cnt))
        dist = {}
        heap = [(-maxMoves, 0)]
        while heap:
            neg_moves, u = heapq.heappop(heap)
            moves = -neg_moves
            if u in dist:
                continue
            dist[u] = moves
            for v, cnt in graph[u]:
                if v not in dist and moves - cnt - 1 >= 0:
                    heapq.heappush(heap, (-(moves - cnt - 1), v))
        ans = len(dist)
        for u, v, cnt in edges:
            from_u = min(dist.get(u, 0), cnt)
            from_v = min(dist.get(v, 0), cnt)
            ans += min(from_u + from_v, cnt)
        return ans
