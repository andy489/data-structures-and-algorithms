# https://leetcode.com/problems/maximize-sum-of-weights-after-edge-removals/

import sys
sys.setrecursionlimit(200000)

class Solution:
    def maximizeSumOfWeights(self, edges: list[list[int]], k: int) -> int:
        n = len(edges) + 1
        adj = [[] for _ in range(n)]
        for u, v, w in edges:
            adj[u].append((v, w))
            adj[v].append((u, w))

        def dfs(v: int, parent: int):
            base = 0
            gains = []
            for c, w in adj[v]:
                if c == parent:
                    continue
                f0, f1 = dfs(c, v)
                base += f0
                gains.append(w + f1 - f0)
            gains.sort(reverse=True)
            f0 = base
            f1 = base
            for i, g in enumerate(gains):
                if g <= 0:
                    break
                if i < k:
                    f0 += g
                if i < k - 1:
                    f1 += g
            return f0, f1

        return dfs(0, -1)[0]
