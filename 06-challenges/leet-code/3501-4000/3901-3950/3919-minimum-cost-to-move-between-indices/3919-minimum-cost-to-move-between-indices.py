# https://leetcode.com/problems/minimum-cost-to-move-between-indices/
from typing import List
import heapq


class Solution:
    def minimumCost(self, nums: List[int], queries: List[List[int]]) -> List[int]:
        n = len(nums)
        closest = [0] * n
        for x in range(n):
            if x == 0:
                closest[x] = 1
            elif x == n - 1:
                closest[x] = n - 2
            else:
                diff_left = nums[x] - nums[x - 1]
                diff_right = nums[x + 1] - nums[x]
                closest[x] = x - 1 if diff_left <= diff_right else x + 1

        # Build adj for cost-1 edges
        adj = [[] for _ in range(n)]
        for x in range(n):
            adj[x].append((closest[x], 1))
            adj[closest[x]].append((x, 1))

        def dijkstra(src, dst):
            if src == dst:
                return 0
            dist = [float('inf')] * n
            dist[src] = 0
            pq = [(0, src)]
            while pq:
                d, u = heapq.heappop(pq)
                if d > dist[u]:
                    continue
                if u == dst:
                    return d
                for v, cost in adj[u]:
                    nd = d + cost
                    if nd < dist[v]:
                        dist[v] = nd
                        heapq.heappush(pq, (nd, v))
                for v in range(n):
                    nd = d + abs(nums[u] - nums[v])
                    if nd < dist[v]:
                        dist[v] = nd
                        heapq.heappush(pq, (nd, v))
            return dist[dst]

        return [dijkstra(l, r) for l, r in queries]
