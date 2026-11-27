# https://leetcode.com/problems/minimum-degree-of-a-connected-trio-in-a-graph/

class Solution:
    def minTrioDegree(self, n: int, edges: list[list[int]]) -> int:
        adj = [[False] * (n + 1) for _ in range(n + 1)]
        deg = [0] * (n + 1)
        for u, v in edges:
            adj[u][v] = adj[v][u] = True
            deg[u] += 1
            deg[v] += 1
        ans = float('inf')
        for i in range(1, n + 1):
            for j in range(i + 1, n + 1):
                if not adj[i][j]:
                    continue
                for k in range(j + 1, n + 1):
                    if adj[i][k] and adj[j][k]:
                        ans = min(ans, deg[i] + deg[j] + deg[k] - 6)
        return ans if ans != float('inf') else -1
