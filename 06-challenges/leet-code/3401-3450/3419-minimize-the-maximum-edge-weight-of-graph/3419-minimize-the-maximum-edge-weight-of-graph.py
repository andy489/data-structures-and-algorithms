# https://leetcode.com/problems/minimize-the-maximum-edge-weight-of-graph/

from collections import defaultdict, deque

class Solution:
    def minMaxWeight(self, n: int, edges: list[list[int]], threshold: int) -> int:
        def can_reach(max_w: int) -> bool:
            by_from = defaultdict(list)
            for u, v, w in edges:
                if w <= max_w:
                    by_from[u].append((w, v))
            rev_adj = defaultdict(list)
            for u, out_edges in by_from.items():
                out_edges.sort()
                for i, (w, v) in enumerate(out_edges):
                    if i >= threshold:
                        break
                    rev_adj[v].append(u)
            visited = [False] * n
            queue = deque([0])
            visited[0] = True
            while queue:
                cur = queue.popleft()
                for nb in rev_adj[cur]:
                    if not visited[nb]:
                        visited[nb] = True
                        queue.append(nb)
            return all(visited)

        lo, hi, ans = 1, 1_000_000, -1
        while lo <= hi:
            mid = (lo + hi) // 2
            if can_reach(mid):
                ans = mid
                hi = mid - 1
            else:
                lo = mid + 1
        return ans
