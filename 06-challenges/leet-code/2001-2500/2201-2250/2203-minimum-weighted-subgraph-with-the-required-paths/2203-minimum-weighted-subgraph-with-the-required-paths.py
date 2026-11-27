# https://leetcode.com/problems/minimum-weighted-subgraph-with-the-required-paths/
class Solution:
    def minimumWeight(self, n: int, edges: List[List[int]], src1: int, src2: int, dest: int) -> int:
        import heapq
        INF = float('inf')

        graph = [[] for _ in range(n)]
        rev_graph = [[] for _ in range(n)]
        for u, v, w in edges:
            graph[u].append((v, w))
            rev_graph[v].append((u, w))

        def dijkstra(g, src):
            dist = [INF] * n
            dist[src] = 0
            pq = [(0, src)]
            while pq:
                d, u = heapq.heappop(pq)
                if d > dist[u]:
                    continue
                for v, w in g[u]:
                    if dist[u] + w < dist[v]:
                        dist[v] = dist[u] + w
                        heapq.heappush(pq, (dist[v], v))
            return dist

        dist1 = dijkstra(graph, src1)
        dist2 = dijkstra(graph, src2)
        dist_dest = dijkstra(rev_graph, dest)

        ans = INF
        for v in range(n):
            if dist1[v] < INF and dist2[v] < INF and dist_dest[v] < INF:
                ans = min(ans, dist1[v] + dist2[v] + dist_dest[v])

        return -1 if ans == INF else ans
