# https://leetcode.com/problems/minimum-cost-to-buy-apples-ii/

import heapq

class Solution:
    def minCostToBuyApples(self, n: int, prices: list[int], roads: list[list[int]]) -> list[int]:
        empty_adj = [[] for _ in range(n)]
        loaded_adj = [[] for _ in range(n)]
        for u, v, cost, tax in roads:
            empty_adj[u].append((v, cost))
            empty_adj[v].append((u, cost))
            loaded_adj[u].append((v, cost * tax))
            loaded_adj[v].append((u, cost * tax))

        def dijkstra(adj, src):
            dist = [float('inf')] * n
            dist[src] = 0
            pq = [(0, src)]
            while pq:
                d, u = heapq.heappop(pq)
                if d > dist[u]:
                    continue
                for v, w in adj[u]:
                    nd = d + w
                    if nd < dist[v]:
                        dist[v] = nd
                        heapq.heappush(pq, (nd, v))
            return dist

        dist_empty = [dijkstra(empty_adj, i) for i in range(n)]
        dist_loaded = [dijkstra(loaded_adj, j) for j in range(n)]

        ans = []
        for i in range(n):
            best = prices[i]
            for j in range(n):
                total = prices[j] + dist_empty[i][j] + dist_loaded[j][i]
                if total < best:
                    best = total
            ans.append(best)
        return ans
