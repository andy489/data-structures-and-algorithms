# https://leetcode.com/problems/count-subtrees-with-max-distance-between-cities/

from collections import deque

class Solution:
    def countSubgraphsForEachDiameter(self, n: int, edges: list[list[int]]) -> list[int]:
        adj = [[] for _ in range(n + 1)]
        for u, v in edges:
            adj[u].append(v)
            adj[v].append(u)

        dist = [[0] * (n + 1) for _ in range(n + 1)]
        for src in range(1, n + 1):
            d = dist[src]
            d[src] = 0
            visited = [-1] * (n + 1)
            visited[src] = 0
            q = deque([src])
            while q:
                u = q.popleft()
                for v in adj[u]:
                    if visited[v] == -1:
                        visited[v] = visited[u] + 1
                        d[v] = visited[v]
                        q.append(v)

        ans = [0] * (n - 1)
        for mask in range(1, 1 << n):
            node_count = bin(mask).count('1')
            if node_count < 2:
                continue
            edge_count = sum(
                1 for u, v in edges
                if (mask >> (u - 1)) & 1 and (mask >> (v - 1)) & 1
            )
            if edge_count != node_count - 1:
                continue
            nodes = [i + 1 for i in range(n) if (mask >> i) & 1]
            diameter = max(
                dist[u][v]
                for idx, u in enumerate(nodes)
                for v in nodes[idx + 1:]
            )
            ans[diameter - 1] += 1
        return ans
