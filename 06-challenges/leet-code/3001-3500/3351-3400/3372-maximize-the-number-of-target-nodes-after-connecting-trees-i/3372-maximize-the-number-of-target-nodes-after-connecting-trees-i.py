# https://leetcode.com/problems/maximize-the-number-of-target-nodes-after-connecting-trees-i/

from collections import deque

class Solution:
    def maxTargetNodes(self, edges1: list[list[int]], edges2: list[list[int]], k: int) -> list[int]:
        def build_adj(edges: list[list[int]], size: int) -> list[list[int]]:
            adj = [[] for _ in range(size)]
            for u, v in edges:
                adj[u].append(v)
                adj[v].append(u)
            return adj

        def bfs_count(adj: list[list[int]], src: int, max_dist: int) -> int:
            dist = [-1] * len(adj)
            dist[src] = 0
            queue = deque([src])
            count = 0
            while queue:
                v = queue.popleft()
                if dist[v] <= max_dist:
                    count += 1
                    for nb in adj[v]:
                        if dist[nb] == -1:
                            dist[nb] = dist[v] + 1
                            if dist[nb] <= max_dist:
                                queue.append(nb)
            return count

        n = len(edges1) + 1
        m = len(edges2) + 1
        adj1 = build_adj(edges1, n)
        adj2 = build_adj(edges2, m)

        best2 = 0
        if k > 0:
            best2 = max(bfs_count(adj2, j, k - 1) for j in range(m))

        return [bfs_count(adj1, i, k) + best2 for i in range(n)]
