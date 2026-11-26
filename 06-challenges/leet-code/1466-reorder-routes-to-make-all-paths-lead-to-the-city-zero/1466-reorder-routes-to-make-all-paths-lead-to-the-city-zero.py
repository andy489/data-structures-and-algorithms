# https://leetcode.com/problems/reorder-routes-to-make-all-paths-lead-to-the-city-zero/

class Solution:
    def minReorder(self, n: int, connections: list[list[int]]) -> int:
        from collections import deque, defaultdict
        adj = defaultdict(list)
        for u, v in connections:
            adj[u].append((v, 1))
            adj[v].append((u, 0))
        visited = [False] * n
        visited[0] = True
        q = deque([0])
        count = 0
        while q:
            u = q.popleft()
            for v, cost in adj[u]:
                if not visited[v]:
                    visited[v] = True
                    count += cost
                    q.append(v)
        return count
