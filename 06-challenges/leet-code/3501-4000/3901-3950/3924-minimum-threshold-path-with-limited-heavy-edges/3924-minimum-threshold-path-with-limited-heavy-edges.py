# https://leetcode.com/problems/minimum-threshold-path-with-limited-heavy-edges/

from collections import deque

class Solution:
    def minimumThreshold(self, n: int, edges: list[list[int]], source: int, target: int, k: int) -> int:
        if source == target:
            return 0
        weights = sorted(set([0] + [e[2] for e in edges]))
        adj = [[] for _ in range(n)]
        for u, v, w in edges:
            adj[u].append((v, w))
            adj[v].append((u, w))

        def can_reach(threshold):
            visited = [[False] * (k + 1) for _ in range(n)]
            queue = deque([(source, 0)])
            visited[source][0] = True
            while queue:
                node, heavy = queue.popleft()
                if node == target:
                    return True
                for nb, w in adj[node]:
                    new_heavy = heavy + (1 if w > threshold else 0)
                    if new_heavy <= k and not visited[nb][new_heavy]:
                        visited[nb][new_heavy] = True
                        queue.append((nb, new_heavy))
            return False

        lo, hi, ans = 0, len(weights) - 1, -1
        while lo <= hi:
            mid = (lo + hi) // 2
            if can_reach(weights[mid]):
                ans = weights[mid]
                hi = mid - 1
            else:
                lo = mid + 1
        return ans
