# https://leetcode.com/problems/second-minimum-time-to-reach-destination/

class Solution:
    def secondMinimum(self, n: int, edges: list[list[int]], time: int, change: int) -> int:
        from collections import deque
        adj = [[] for _ in range(n + 1)]
        for u, v in edges:
            adj[u].append(v)
            adj[v].append(u)
        INF = float('inf')
        dist1 = [INF] * (n + 1)
        dist2 = [INF] * (n + 1)
        dist1[1] = 0
        q = deque([(1, 0)])
        while q:
            u, d = q.popleft()
            for v in adj[u]:
                if d + 1 < dist1[v]:
                    dist2[v] = dist1[v]
                    dist1[v] = d + 1
                    q.append((v, dist1[v]))
                elif dist1[v] < d + 1 < dist2[v]:
                    dist2[v] = d + 1
                    q.append((v, dist2[v]))
        steps = dist2[n] if dist2[n] != INF else dist1[n] + 1
        t = 0
        for _ in range(steps):
            if (t // change) % 2 == 1:
                t = (t // change + 1) * change
            t += time
        return t
