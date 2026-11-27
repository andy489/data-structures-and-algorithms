# https://leetcode.com/problems/the-time-when-the-network-becomes-idle/

class Solution:
    def networkBecomesIdle(self, edges: list[list[int]], patience: list[int]) -> int:
        from collections import deque
        n = len(patience)
        adj = [[] for _ in range(n)]
        for u, v in edges:
            adj[u].append(v)
            adj[v].append(u)
        dist = [-1] * n
        dist[0] = 0
        q = deque([0])
        while q:
            u = q.popleft()
            for v in adj[u]:
                if dist[v] == -1:
                    dist[v] = dist[u] + 1
                    q.append(v)
        ans = 0
        for i in range(1, n):
            d = 2 * dist[i]
            resends = (d - 1) // patience[i]
            last_arrival = patience[i] * resends + d
            ans = max(ans, last_arrival + 1)
        return ans
